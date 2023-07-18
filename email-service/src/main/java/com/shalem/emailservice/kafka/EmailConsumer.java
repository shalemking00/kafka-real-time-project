package com.shalem.emailservice.kafka;

import com.shalem.basedomains.dto.OderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    Logger logger= LoggerFactory.getLogger(EmailConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OderEvent event){
        logger.info(String.format("from email service event consumed => %s",event.getOrder().toString()));


    }

}
