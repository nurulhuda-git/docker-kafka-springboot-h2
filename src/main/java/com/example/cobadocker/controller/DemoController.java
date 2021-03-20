package com.example.cobadocker.controller;

import lombok.extern.slf4j.Slf4j;

import com.example.cobadocker.config.KafkaProperties;
import com.example.cobadocker.entity.Akun;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class DemoController {
    @Autowired
    private KafkaTemplate<String, Akun> kafkaProducer;
    @Autowired
    private KafkaProperties kafkaProperties;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendProjectStatusEmail(@RequestBody Akun statusChange) {
        log.info("Sending mailing request: " + statusChange.toString() + "\nKafka Properties :" + kafkaProperties.getTopics().getProjectStatusChanged());
        // kafkaProducer.send(kafkaProperties.getTopics().getProjectStatusChanged(), statusChange);
        kafkaProducer.send(kafkaProperties.getTopics().getProjectStatusChanged(), String.valueOf(statusChange.getId()), statusChange);
    }
}