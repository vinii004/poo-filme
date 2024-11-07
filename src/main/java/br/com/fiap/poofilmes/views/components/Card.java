package br.com.fiap.poofilmes.views.components;

import br.com.fiap.poofilmes.service.ProducaoService;
import br.com.fiap.poofilmes.model.Classificavel;
import br.com.fiap.poofilmes.model.Producao;
import br.com.fiap.poofilmes.model.Serie;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Card extends HorizontalLayout {

    public Card(Producao producao) {
        setWidthFull();
        setPadding(true);
        getStyle().setBackground("var(--lumo-contrast-5pct)");

        Image image = new Image(producao.getPoster(), "poster");
        image.setWidth("200px");
        image.setHeight("300px");

        add(image);

        VerticalLayout dados = new VerticalLayout();
        dados.setSpacing(false);

        dados.add(new H3(producao.getTitulo()));
        dados.add(new Paragraph(producao.getGenero()));
        dados.add(new Paragraph(String.valueOf(producao.getDataLancamento().getYear())));

        String tipo = producao.getClass().getSimpleName();
        String cor = tipo.equals("Filme") ? "red" : "green";
        var tag = new Paragraph();
        tag.getStyle().set("background-color", cor);
        tag.getStyle().set("color", "white");
        tag.getStyle().set("padding", "5px");
        tag.getStyle().set("border-radius", "5px");
        tag.getStyle().set("font-size", "10px");
        tag.setText(tipo);
        dados.add(tag);

        HorizontalLayout stars = new HorizontalLayout();
        ProducaoService producaoService = new ProducaoService();
        int avaliacaoGlobal = producaoService.calcularAvaliacaoGeral((Classificavel) producao);
        for (int i = 0; i < avaliacaoGlobal; i++) {
            var star = new Paragraph("⭐");
            star.getStyle().set("color", "gold");
            star.getStyle().set("font-size", "20px");
            stars.add(star);
        }
        dados.add(stars);

        if (tipo.equals("Serie")) {
            Accordion accordion = new Accordion();
            Serie serie = (Serie) producao;
            var episodios = new VerticalLayout();
            serie.getEpisodios().forEach(
                    episodio -> {
                        var episodioLayout = new VerticalLayout(
                                new Span(episodio.getTitulo()),
                                new Span(episodio.getAvaliacao() + "⭐")
                        );
                        episodios.add(episodioLayout);
                    }
            );
            episodios.setSpacing(false);
            episodios.setMargin(false);
            accordion.add("Episodios", episodios);

            accordion.close();
            dados.add(accordion);
        }

        add(dados);
    }
}
