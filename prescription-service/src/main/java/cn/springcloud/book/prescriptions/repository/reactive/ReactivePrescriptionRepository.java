package cn.springcloud.book.prescriptions.repository.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import cn.springcloud.book.prescriptions.model.Prescription;

public interface ReactivePrescriptionRepository extends ReactiveMongoRepository<Prescription, String> {

}
