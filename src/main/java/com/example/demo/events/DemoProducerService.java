package com.example.demo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class DemoProducerService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(String topic, String message) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<String, String>> messageSentSuccessfully = kafkaTemplate.send(topic, message).whenComplete((record, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
            } else {
                System.out.println("Message sent successfully");
            }

        });

        return messageSentSuccessfully.get().toString();
    }

}
