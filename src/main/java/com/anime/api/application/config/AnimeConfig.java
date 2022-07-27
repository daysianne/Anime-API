package com.anime.api.application.config;

import com.anime.api.domain.port.AnimeRepository;
import com.anime.api.domain.service.AnimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimeConfig {

    @Bean
    public AnimeService animeService(AnimeRepository animeRepository) {
        return new AnimeService(animeRepository);
    }

}
