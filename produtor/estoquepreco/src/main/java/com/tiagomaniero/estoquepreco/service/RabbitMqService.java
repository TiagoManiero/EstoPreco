package com.tiagomaniero.estoquepreco.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarMensagem(String nomeFila, Object mensagem){
        try {
            objectMapper.writeValueAsString(mensagem);
            rabbitTemplate.convertAndSend(nomeFila, mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
