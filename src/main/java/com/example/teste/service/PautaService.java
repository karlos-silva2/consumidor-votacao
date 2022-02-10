package com.example.teste.service;

import com.example.teste.entities.Pauta;

public interface PautaService {

    void atualizarPauta(Pauta pauta);

    Pauta findByNumeroPauta(Integer numeroPauta);

}