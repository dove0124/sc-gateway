package cn.springcloud.book.prescriptions.events.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import cn.springcloud.book.prescriptions.events.CardChangeChannel;
import cn.springcloud.book.prescriptions.events.models.CardChangeModel;
import cn.springcloud.book.prescriptions.repository.reactive.ReactiveCardRedisRepository;

@EnableBinding(CardChangeChannel.class)
public class CardChangeHandler {

	@Autowired
    ReactiveCardRedisRepository reactiveCardRedisRepository;

    private static final Logger logger = LoggerFactory.getLogger(CardChangeHandler.class);

    @StreamListener("inboundCardChanges")
    public void cardChangeSink(CardChangeModel cardChangeModel) {
    	
        logger.info("Received a message of type " + cardChangeModel.getType());
    	logger.info("Received a {} event from the account service for account id {}",
    			cardChangeModel.getOperation(), 
    			cardChangeModel.getCard().getId());
        
    	System.out.println("Received a message of type " + cardChangeModel.getType());
    	
        if(cardChangeModel.getOperation().equals("UPDATE")) {
        	reactiveCardRedisRepository.updateCard(cardChangeModel.getCard());        	
        } else if(cardChangeModel.getOperation().equals("DELETE")) {
        	reactiveCardRedisRepository.deleteCard(cardChangeModel.getCard().getId());
        } else {            
            logger.error("Received an UNKNOWN event from the account service of type {}", cardChangeModel.getType());
        }
    }
}
