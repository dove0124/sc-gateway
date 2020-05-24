package cn.springcloud.book.prescriptions.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springcloud.book.prescriptions.clients.ReactiveCardClient;
import cn.springcloud.book.prescriptions.clients.ReactiveMedicineClient;
import cn.springcloud.book.prescriptions.model.Card;
import cn.springcloud.book.prescriptions.model.Medicine;
import cn.springcloud.book.prescriptions.model.Prescription;
import cn.springcloud.book.prescriptions.repository.reactive.ReactivePrescriptionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrescriptionService {

    @Autowired
    private ReactivePrescriptionRepository reactivePrescriptionRepository;

    @Autowired
    private ReactiveMedicineClient medicineClient;

    @Autowired
    private ReactiveCardClient cardClient;

    private static final Logger logger = LoggerFactory.getLogger(PrescriptionService.class);

    @HystrixCommand
    private Mono<Card> getCard(String cardId) {

        return cardClient.getCard(cardId)
                         .log("getCard", Level.ALL);
    }

    @HystrixCommand
    private Mono<Medicine> getMedicine(String medicineCode) {

        return medicineClient.getMedicine(medicineCode)
                             .log("getMedicine", Level.ALL);
    }

    public Mono<Prescription> addPrescription(String cardId, String medicineCode) {
        logger.info("add prescription with card: {} and medicine: {}", cardId, medicineCode);

        Prescription prescription = new Prescription();
        prescription.setId("P_" + UUID.randomUUID()
                                      .toString());

        Mono<Medicine> medicine = getMedicine(medicineCode);
        medicine.flatMap(m -> {
            if (m != null) {
                logger.info("get medicine: {} is successful", medicineCode);

                prescription.setMedicineCode(medicineCode);
                prescription.setMedicineName(m.getMedicineName());
            }

            return Mono.just(m);
            //        });
        })
                .block();

        Mono<Card> card = getCard(cardId);
        card.flatMap(c -> {
            if (c != null) {
                logger.info("get card: {} is successful", cardId);

                prescription.setCardId(cardId);
                prescription.setCardName(c.getCardName());
            }

            return Mono.just(c);
            //        });
        })
            .block();

        if (prescription.getCardId() == null || prescription.getMedicineCode() == null) {
            logger.warn("empty CardId: ", prescription.getCardId() + " ,MedicineCode: ", prescription.getMedicineCode());
            return Mono.empty();
        }

        prescription.setCreateTime(new Date());

        Mono<Prescription> savedPrescription = reactivePrescriptionRepository.save(prescription)
                                                                             .log("savePrescription", Level.ALL);

        return savedPrescription;
    }

    @HystrixCommand(fallbackMethod = "getPrescriptionsFallback")
    public Flux<Prescription> getPrescriptions() {
        return reactivePrescriptionRepository.findAll();
    }

    @SuppressWarnings("unused")
    private Flux<Prescription> getPrescriptionsFallback() {
        List<Prescription> fallbackList = new ArrayList<>();

        Prescription prescription = new Prescription();
        prescription.setId("InvalidPrescriptionId");
        prescription.setCardId("InvalidCardId");
        prescription.setMedicineCode("InvalidMedicineCode");
        prescription.setCreateTime(new Date());
        fallbackList.add(prescription);

        return Flux.fromIterable(fallbackList);
    }

    @HystrixCommand(fallbackMethod = "getPrescriptionFallback")
    public Mono<Prescription> getPrescriptionById(String id) {
        return reactivePrescriptionRepository.findById(id);
    }

    @SuppressWarnings("unused")
    private Mono<Prescription> getPrescriptionFallback(String id) {
        Prescription prescription = new Prescription();
        prescription.setId(id);
        prescription.setCardId("InvalidCardId");
        prescription.setMedicineCode("InvalidMedicineCode");
        prescription.setCreateTime(new Date());

        return Mono.just(prescription);
    }
}
