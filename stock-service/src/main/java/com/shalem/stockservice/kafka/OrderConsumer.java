package com.shalem.stockservice.kafka;

import com.shalem.basedomains.dto.OderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    Logger logger= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OderEvent event){
        logger.info(String.format("event consumed => %s",event.getOrder().toString()));

        // write the code to store the  data from the events


    }

}
