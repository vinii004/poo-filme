package br.com.fiap.poofilmes.repository;

import br.com.fiap.poofilmes.model.Episodio;
import br.com.fiap.poofilmes.model.Filme;
import br.com.fiap.poofilmes.model.Producao;
import br.com.fiap.poofilmes.model.Serie;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ProducaoRepository {

    private List<Producao> producoes = new ArrayList<>();

    public ProducaoRepository() {
        producoes.add(new Serie("The Mandalorian", LocalDate.of(2023, 2, 3), "Ficção Científica", "https://media.themoviedb.org/t/p/w440_and_h660_face/7LtBtEnuFWUNHxbP93gwL199giY.jpg", 2, 5));
        producoes.add(new Filme("The Irishman", LocalDate.of(2019,11,13), "Drama", "https://media.themoviedb.org/t/p/w440_and_h660_face/3GPn2W2UdzUE1bp1KtCrYvXiZFt.jpg", "Martin Scorsese", 4) );
        Serie bb = new Serie("Breaking Bad", LocalDate.of(2008,1,20), "Drama", "https://media.themoviedb.org/t/p/w440_and_h660_face/30erzlzIOtOK3k3T3BAl1GiVMP1.jpg", 5, 3);
        bb.getEpisodios().add(new Episodio("Episodio 1", "Drama", LocalDate.of(2008,1,20), "https://media.themoviedb.org/t/p/w440_and_h660_face/30erzlzIOtOK3k3T3BAl1GiVMP1.jpg", 1, 1, 5));
        bb.getEpisodios().add(new Episodio("Episodio 2", "Drama", LocalDate.of(2008,1,20), "https://media.themoviedb.org/t/p/w440_and_h660_face/30erzlzIOtOK3k3T3BAl1GiVMP1.jpg", 1, 2, 4));
        producoes.add(bb);

    }

    public List<Producao> findAll() {
        return producoes;
    }

    public void create(Producao producao) {
        producoes.add(producao);

        if(producao instanceof Serie){
            Serie serie = (Serie) producao;
            for (int i = 1; i <= 4; i++) {
                Episodio episodio = new Episodio(
                        serie.getTitulo() + " - Episodio " + i,
                        producao.getGenero(),
                        LocalDate.now(),
                        "https://media.themoviedb.org/t/p/w440_and_h660_face/3X3nUDxbaporC4GiByRX5pz6RZY.jpg",
                        1,
                        i,
                        new Random().nextInt(5)

                );
                serie.getEpisodios().add(episodio);
            }

        }

    }
}
