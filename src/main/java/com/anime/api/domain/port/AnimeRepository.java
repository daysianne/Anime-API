package com.anime.api.domain.port;

import com.anime.api.domain.domain.Anime;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnimeRepository {

    Anime salvar(Anime anime);

    public List<Anime> findAnime();

   Anime findById(Long codigo);

    void delete(Long codigo);
}
