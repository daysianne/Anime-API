package com.anime.api.repository;

import com.anime.api.model.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    public Page<Anime> findByNomeContaining(String nome, Pageable pageable);

}
