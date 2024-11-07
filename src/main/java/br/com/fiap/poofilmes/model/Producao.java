package br.com.fiap.poofilmes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producao {

    private String titulo;
    private LocalDate dataLancamento;
    private String genero;
    private String poster;
    private int avaliacao = 0;

}
