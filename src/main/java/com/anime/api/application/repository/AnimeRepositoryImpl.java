package com.anime.api.application.repository;

import com.anime.api.application.repository.jpa.AnimeJpa;
import com.anime.api.application.repository.jpa.entity.AnimeEntity;
import com.anime.api.domain.domain.Anime;
import com.anime.api.domain.port.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpa animeJpa;

    @Override
    public Anime salvar(Anime anime) {
        try {
            var animeEntity = animeJpa.save(AnimeMapper.paraEntity(anime));
            return AnimeMapper.entityParaDominio(animeEntity);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar o anime. {}", anime, e);
            throw e;
        }
    }

    public List<Anime> findAnime() {
        var animeEntity = animeJpa.findAll();

        return AnimeMapper.paraListaDominio(animeEntity);

    }

    @Override
    public Anime findById(Long codigo) {
        try {
            AnimeEntity animeEntity = animeJpa.findById(codigo).orElse(null);
            return AnimeMapper.entityParaDominio(animeEntity);
        } catch (Exception e) {
            log.error("Erro ao tentar buscar o anime. {}", codigo, e);
            throw e;
        }
    }

    @Override
    public void delete(Long codigo) {
        animeJpa.deleteById(codigo);
    }
}
