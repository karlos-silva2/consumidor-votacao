package com.example.teste.service.implementation;

import com.example.teste.entities.Pauta;
import com.example.teste.repositories.PautaRepository;
import com.example.teste.service.PautaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaServiceImpl implements PautaService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public void atualizarPauta(Pauta pauta) {
        pautaRepository.save(pauta);
    }

    public Pauta findByNumeroPauta(Integer numeroPauta){
        return pautaRepository.findByNumeroPauta(numeroPauta);
    }
}
