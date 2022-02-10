package com.example.teste.service.implementation;

import com.example.teste.entities.Pauta;
import com.example.teste.entities.Votacao;
import com.example.teste.entities.request.VotacaoRequest;
import com.example.teste.service.PautaService;
import com.example.teste.service.ServiceVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceVotoImpl implements ServiceVoto {

    @Autowired
    private PautaService pautaService;

    @Override
    public void salvaVoto(VotacaoRequest votacaoRequest){
        List<Votacao> votacaoList;
        Pauta pautaPresente = pautaService.findByNumeroPauta(votacaoRequest.getNumeroPauta());
        if (Objects.nonNull(pautaPresente.getVotacoes())) {
            votacaoList = pautaPresente.getVotacoes();
        }else{
            votacaoList = new ArrayList<>();
        }

        Votacao votacao = new Votacao();
        votacao.setNome(votacaoRequest.getNome());
        votacao.setCpf(votacaoRequest.getCpf());
        votacao.setVoto(votacaoRequest.getVoto());
        votacao.setData(new Date());
        votacaoList.add(votacao);
        pautaPresente.setVotacoes(votacaoList);

        //Chamara interface para relizar a gravação no banco
        pautaService.atualizarPauta(pautaPresente);
    }
}
