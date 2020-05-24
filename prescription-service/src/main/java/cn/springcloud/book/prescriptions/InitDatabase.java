
package cn.springcloud.book.prescriptions;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import cn.springcloud.book.prescriptions.model.Prescription;

@Component
public class InitDatabase {
	@Bean
	CommandLineRunner init(MongoOperations operations) {
		return args -> {
			operations.dropCollection(Prescription.class);
		};
	}
}
