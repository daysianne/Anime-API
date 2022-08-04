package com.anime.api.domain.service;

import com.anime.api.application.presentation.representation.AnimeResponseRepresentation;
import com.anime.api.domain.domain.Anime;
import com.anime.api.domain.enums.TipoGenero;
import com.anime.api.domain.port.AnimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Slf4j
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(final AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime salvar(Anime anime) {
        try {
            return this.animeRepository.salvar(anime);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar um anime. {}", anime, e);
            throw e;
        }
    }

    public Anime buscarPeloCodigo(Long codigo) {
        Anime anime = this.animeRepository.buscarPorId(codigo);
        return anime;
    }

    public List<Anime> pesquisar() {
        return animeRepository.listarAnime();
    }

    public void delete(long cod) {
        animeRepository.delete(cod);
    }

    public Anime atualizar(Long codigo, Anime anime) {
        Anime animeSalvo = this.animeRepository.buscarPorId(codigo);

        BeanUtils.copyProperties(anime, animeSalvo, "id");
        return this.animeRepository.salvar(animeSalvo);
    }
}
