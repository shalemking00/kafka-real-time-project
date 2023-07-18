package com.shalem.orderservice.kafka;

import com.shalem.basedomains.dto.OderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private NewTopic topic;

    @Autowired
    public KafkaTemplate<String, OderEvent> kafkaTemplate;

    public void sendMessage(OderEvent event){
        logger.info(String.format("Order event => %s",event.toString()));

        Message<OderEvent> message= MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,topic.name()).build();

        kafkaTemplate.send(message);

    }

}
