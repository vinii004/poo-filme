package br.com.fiap.poofilmes.service;

import br.com.fiap.poofilmes.model.Classificavel;
import org.springframework.stereotype.Service;

@Service
public class ProducaoService {

    public int calcularAvaliacaoGeral(Classificavel classificavel) {
        return classificavel.calcularAvaliacao();
    }

}
