package com.anime.api.application.presentation.controller;

import com.anime.api.application.mapper.AnimeMapper;
import com.anime.api.application.presentation.representation.AnimeRequestRepresentation;
import com.anime.api.application.presentation.representation.AnimeResponseRepresentation;
import com.anime.api.domain.domain.Anime;
import com.anime.api.domain.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/v2/animes")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService service;

    @PostMapping
    public ResponseEntity<AnimeResponseRepresentation> salvar(@RequestBody AnimeRequestRepresentation body) {
        var anime = service.salvar(AnimeMapper.paraDominio(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(anime));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<AnimeResponseRepresentation> buscarPeloCodigo(@PathVariable Long codigo) {
       // Anime anime = this.animeRepository.findById(codigo).orElse(null);
        Anime anime = service.buscarPeloCodigo(codigo);
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(anime));
        }

        return  ResponseEntity.notFound().build();

    }

    @GetMapping
    public List<Anime> pesquisar(@RequestParam(required = false, defaultValue = "") String nome, Pageable pageable) {
        return service.pesquisar();

    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long codigo) {
       // Anime anime =  service.buscarPeloCodigo(codigo);

       // this.service.delete(anime);
        this.service.delete(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Anime> atualizar(@PathVariable Long codigo, @RequestBody Anime anime) {
        Anime animeSalva = service.atualizar(codigo, anime);

        return ResponseEntity.ok(animeSalva);
    }


}
