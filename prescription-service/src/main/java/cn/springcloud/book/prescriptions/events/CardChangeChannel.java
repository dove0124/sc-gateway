package cn.springcloud.book.prescriptions.events;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CardChangeChannel {
	
    @Input("inboundCardChanges")
    SubscribableChannel cardChangeChannel();
}
