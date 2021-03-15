package me.gabreuw.metodo_get_parte2.resource;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.metodo_get_parte2.domain.Anime;
import me.gabreuw.metodo_get_parte2.service.AnimeService;
import me.gabreuw.metodo_get_parte2.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "animes")
@Log4j2
public class AnimeResource {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyles(LocalDateTime.now()));

        return ResponseEntity
                .ok()
                .body(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity
                .ok()
                .body(animeService.findById(id));
    }

}
