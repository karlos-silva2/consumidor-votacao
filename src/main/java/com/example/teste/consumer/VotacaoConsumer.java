package com.example.teste.consumer;

import com.example.teste.constants.RabbitMQConstants;
import com.example.teste.entities.request.VotacaoRequest;
import com.example.teste.service.ServiceVoto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VotacaoConsumer {

    @Autowired
    private ServiceVoto serviceVoto;

    @RabbitListener(queues = RabbitMQConstants.FILA_VOTACAO)
    private void consumidor(VotacaoRequest votacaoRequest){
        serviceVoto.salvaVoto(votacaoRequest);
    }
}