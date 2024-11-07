package br.com.fiap.poofilmes.views;

import br.com.fiap.poofilmes.repository.ProducaoRepository;
import br.com.fiap.poofilmes.views.components.Card;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class GridView extends VerticalLayout {


    public GridView(ProducaoRepository producaoRepository) {

        var producoes = producaoRepository.findAll();
        producoes.forEach(producao -> add(new Card(producao)));

    }

}
