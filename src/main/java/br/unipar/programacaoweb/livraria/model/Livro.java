package br.unipar.programacaoweb.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    private Integer numeroPaginas;

    private String genero;

    @ManyToOne
    @JoinColumn(name = "autor_id") // cria a chave estrangeira no banco
    private Autor autor;


}
