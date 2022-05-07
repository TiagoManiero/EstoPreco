package com.tiagomaniero.estoquepreco.controller;

import com.tiagomaniero.estoquepreco.service.RabbitMqService;
import constantes.RabbitmqConstantes;
import model.PrecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @PutMapping
    private ResponseEntity<?> alteraPreco(@RequestBody PrecoDto precoDto){
        rabbitMqService.enviarMensagem(RabbitmqConstantes.FILA_PRECO, precoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
