package com.anime.api.resource;

import com.anime.api.model.Anime;
import com.anime.api.repository.AnimeRepository;
import com.anime.api.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/anime")
public class AnimeResource {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private AnimeService animeService;

    @PostMapping
    public ResponseEntity<Anime> criar(@RequestBody Anime anime, HttpServletResponse reponse){
        Anime animeSalvo = animeRepository.save(anime);

        // publisher

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(animeSalvo);

    }

    @GetMapping
    public Page<Anime> pesquisar(@RequestParam(required = false, defaultValue = "") String nome, Pageable pageable) {
        return animeRepository.findByNomeContaining(nome, pageable);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Anime> buscarPeloCodigo(@PathVariable Long codigo) {
        Anime anime = this.animeRepository.findById(codigo).orElse(null);
        return anime != null ? ResponseEntity.ok(anime) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente (@PathVariable Long codigo) {
        Anime anime =  this.animeRepository.findById(codigo).orElse(null);

        this.animeRepository.delete(anime);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Anime> atualizar(@PathVariable Long codigo, @RequestBody Anime anime) {
        Anime animeSalva = animeService.atualizar(codigo, anime);

        return ResponseEntity.ok(animeSalva);
    }

}
