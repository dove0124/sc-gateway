package cn.springcloud.book.card.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springcloud.book.card.events.source.ReactiveCardChangeSource;
import cn.springcloud.book.card.model.Card;
import cn.springcloud.book.card.repository.reactive.ReactiveCardRepository;

import reactor.core.publisher.Mono;

@Service
public class CardService {
    @Autowired
    private ReactiveCardRepository reactiveCardRepository;

    @Autowired
    private ReactiveCardChangeSource reactiveCardChangeSource;

    public Mono<Card> getCardById(String cardId) {
        return reactiveCardRepository.findById(cardId);
    }

    public Mono<Card> getCardByCode(String cardCode) {
        return reactiveCardRepository.findByCardCode(cardCode);
    }

    public Mono<Card> getCardByName(String cardName) {
        return reactiveCardRepository.findById(cardName);
    }

    public Mono<Card> saveCard(Card card){
    	Mono<Card> saveCard = reactiveCardRepository.save(card);
    	
    	return saveCard;
    }

    public Mono<Void> updateCard(Card card){
    	Mono<Card> saveCard = reactiveCardRepository.save(card);
    	   	
    	Mono<Void> updatedEvent = reactiveCardChangeSource.publishReactiveCardUpdatedEvent(card);
    	
    	return Mono.when(saveCard, updatedEvent);
    }

    public Mono<Void> deleteCard(Card card){
    	Mono<Void> deleteCard = reactiveCardRepository.delete(card);
   	
    	Mono<Void> deletedEvent = reactiveCardChangeSource.publishReactiveCardDeletedEvent(card);
    	
    	return Mono.when(deleteCard, deletedEvent);
    }
}
