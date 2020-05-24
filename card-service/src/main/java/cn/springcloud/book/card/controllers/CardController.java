package cn.springcloud.book.card.controllers;

import cn.springcloud.book.card.model.Card;
import cn.springcloud.book.card.services.CardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class CardController {

    @Autowired
    private CardService cardService;

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);

    @GetMapping("/cards/{cardId}")
    public Mono<Card> getCard(@PathVariable("cardId") String cardId) {
        Mono<Card> card = cardService.getCardById(cardId);
        return card;
    }

    @GetMapping("/cards/code/{cardCode}")
    public Mono<Card> getCardByCode(@PathVariable("cardCode") String cardCode) {
        Mono<Card> card = cardService.getCardByCode(cardCode);
        return card;
    }

    @GetMapping("/cards/name/{cardName}")
    public Mono<Card> getCardByName(@PathVariable("cardName") String cardName) {
        Mono<Card> card = cardService.getCardByName(cardName);
        return card;
    }

    @PutMapping("/cards")
    public Mono<Void> updateCard(@RequestBody Card card) {
        return cardService.updateCard(card);
    }

    @PostMapping("/cards")
    public Mono<Void> saveCard(@RequestBody Card card) {
        return cardService.updateCard(card);
    }

    @DeleteMapping("/cards/{cardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCard(@PathVariable("cardId") String cardId) {
        Card card = new Card();
        card.setId(cardId);

        return cardService.deleteCard(card);
    }
}
