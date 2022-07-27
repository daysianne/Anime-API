package com.anime.api.application.repository.jpa.entity;

import com.anime.api.domain.enums.TipoGenero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anime")
public class AnimeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "ano_publicacao")
    private int anoPublicacao;

    @Column(name = "numero_episodios")
    private int numeroEpisodios;

    @Column(name = "sinopse", columnDefinition = "TEXT")
    private String sinopse;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private TipoGenero tipoGenero;

//    @Column(name = "insert_date_time")
//    private LocalDateTime insertDateTime;
//
//    @Column(name = "update_date_time")
//    private LocalDateTime updateDateTime;
//
//    @PrePersist
//    public void prePersist() {
//        insertDateTime = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        updateDateTime = LocalDateTime.now();
//    }

}
