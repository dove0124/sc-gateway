package cn.springcloud.book.card.repository.reactive;

import cn.springcloud.book.card.model.Card;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface ReactiveCardRepository extends ReactiveMongoRepository<Card, String> {

    public Mono<Card> findByCardCode(String code);

    public Mono<Card> findByCardName(String name);
}
