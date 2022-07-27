package com.anime.api.domain.port;

import com.anime.api.application.presentation.representation.AnimeResponseRepresentation;
import com.anime.api.domain.domain.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AnimeRepository {

    Anime salvar(Anime anime);

    public Page<Anime> findByNomeContaining(String nome, Pageable pageable);

   Anime findById(Long codigo);

    void delete(Long codigo);
}
