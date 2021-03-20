package com.example.cobadocker.listener;

import lombok.extern.slf4j.Slf4j;

import com.example.cobadocker.entity.Akun;
import com.example.cobadocker.repository.AkunRepository;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener 
{
    @Autowired
    private AkunRepository akunRepository;

    @KafkaListener(topicPattern = "${kafka.topics.project-status-changed}", autoStartup = "${kafka.enabled}")
    public void listenToProjectStatusChange(ConsumerRecord<String, Akun> record) {
        log.info("Request for project status change received: " + record.toString());

        Akun payload = record.value();

        if (payload.getId() == 0) {
            log.warn("Ignoring request to send an e-mail without e-mail address: " + record.toString());
            return;
        }

        try 
        {
            log.info("Payload:{}", payload.getName());

            // TODO : Listener

            if(akunRepository.findById(payload.getId()).isPresent())
            {
                Akun akun = akunRepository.findById(payload.getId()).get();
                akun.setName(payload.getName());
                akunRepository.save(akun);
            }
            else
                akunRepository.save(payload);

        } catch (Exception e) {
            log.error("Could not send e-mail", e);
        }
    }
}