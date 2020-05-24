package cn.springcloud.book.medicine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import cn.springcloud.book.medicine.model.Medicine;
import cn.springcloud.book.medicine.repository.reactive.ReactiveMedicineRepository;
import cn.springcloud.book.medicine.services.MedicineService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineServiceTest {

	@Autowired
	MedicineService service;
	
	@MockBean
	ReactiveMedicineRepository repository;

	@Test
	public void testGetByMedicineCode() {
		Medicine mockMedicine = new Medicine("Medicine-Id1", "001", "Medicine001",
				"New Medicine001", 100F);
		
		given(repository.getByMedicineCode("001")).willReturn(Mono.just(mockMedicine));
		
		Mono<Medicine> medicine = service.getMedicineByCode("001");
		
		StepVerifier.create(medicine).expectNextMatches(results -> {
			assertThat(results.getMedicineCode()).isEqualTo("Medicine001");
			assertThat(results.getMedicineName()).isEqualTo("New Medicine001");
			return true;
		}).verifyComplete();
		
	}	
}


