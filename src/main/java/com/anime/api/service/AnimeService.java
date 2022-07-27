package com.anime.api.service;

import com.anime.api.model.Anime;
import com.anime.api.repository.AnimeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public Anime atualizar(Long codigo, Anime anime) {
        Anime animeSalvo = this.animeRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(anime, animeSalvo, "id");
        return this.animeRepository.save(animeSalvo);

    }

}
