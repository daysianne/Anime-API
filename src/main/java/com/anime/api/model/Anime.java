package com.anime.api.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private String autor;

    @NotNull
    private int ano_publicacao;

    @NotNull
    private int numero_episodios;

    @NotNull
    private String genero;

    @NotNull
    private String sinopse;
}
