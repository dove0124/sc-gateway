package cn.springcloud.book.medicine.repository.reactive;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import cn.springcloud.book.medicine.model.Medicine;

import reactor.core.publisher.Mono;

public interface ReactiveMedicineRepository 
	extends ReactiveMongoRepository<Medicine, String> {

	Mono<Medicine> getByMedicineCode(String productCode);	
}
