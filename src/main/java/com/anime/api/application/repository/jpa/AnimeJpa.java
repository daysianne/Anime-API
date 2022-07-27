package com.anime.api.application.repository.jpa;

import com.anime.api.application.repository.jpa.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeJpa extends JpaRepository<AnimeEntity, Long> {}
