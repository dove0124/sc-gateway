
package cn.springcloud.book.card;

import cn.springcloud.book.card.model.Card;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {

    @Bean
    CommandLineRunner init(MongoOperations operations) {
        return args -> {
            operations.dropCollection(Card.class);

            operations.insert(new Card("C_" + UUID.randomUUID()
                                                  .toString(), "C001", "andy chu1"));
            operations.insert(new Card("C_" + UUID.randomUUID()
                                                  .toString(), "C002", "andy chu2"));

            operations.findAll(Card.class)
                      .forEach(card -> {
                          System.out.println(card.getId());
                      });
        };
    }
}
