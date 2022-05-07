package com.tiagomaniero.estoquepreco.controller;

import com.tiagomaniero.estoquepreco.service.RabbitMqService;
import constantes.RabbitmqConstantes;
import model.EstoqueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @PutMapping
    private ResponseEntity<?> alteraEstoque(@RequestBody EstoqueDto estoqueDto){
        rabbitMqService.enviarMensagem(RabbitmqConstantes.FILA_ESTOQUE, estoqueDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
