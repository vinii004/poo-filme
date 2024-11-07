package br.com.fiap.poofilmes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episodio extends Producao{

    private int temporada;
    private int numero;

    public Episodio(String titulo, String genero, LocalDate dataLancamento, String poster, int temporada, int numero, int avaliacao) {
        super(titulo, dataLancamento, genero, poster, avaliacao);
        this.temporada = temporada;
        this.numero = numero;
    }


}
