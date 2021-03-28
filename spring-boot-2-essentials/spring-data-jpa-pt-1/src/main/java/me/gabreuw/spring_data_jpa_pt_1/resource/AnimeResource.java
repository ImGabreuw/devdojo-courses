package me.gabreuw.spring_data_jpa_pt_1.resource;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.spring_data_jpa_pt_1.domain.Anime;
import me.gabreuw.spring_data_jpa_pt_1.service.AnimeService;
import me.gabreuw.spring_data_jpa_pt_1.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Anime> save(
            @RequestBody Anime anime
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(animeService.save(anime));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        animeService.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping
    public ResponseEntity<Void> update(
            @RequestBody Anime anime
    ) {
        animeService.update(anime);

        return ResponseEntity
                .noContent()
                .build();
    }

}
