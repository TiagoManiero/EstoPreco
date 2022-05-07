package com.tiagomaniero.consumidorestoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import constantes.RabbitmqConstantes;
import model.EstoqueDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
    private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {
        EstoqueDto estoqueDto = new ObjectMapper().readValue(mensagem, EstoqueDto.class);

        System.out.println(estoqueDto.codigoProduto);
        System.out.println(estoqueDto.quantidade);
    }
}
