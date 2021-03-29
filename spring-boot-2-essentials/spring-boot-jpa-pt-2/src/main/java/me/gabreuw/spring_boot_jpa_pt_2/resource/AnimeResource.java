package me.gabreuw.spring_boot_jpa_pt_2.resource;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.spring_boot_jpa_pt_2.domain.Anime;
import me.gabreuw.spring_boot_jpa_pt_2.request.AnimePostRequestBody;
import me.gabreuw.spring_boot_jpa_pt_2.request.AnimePutRequestBody;
import me.gabreuw.spring_boot_jpa_pt_2.service.AnimeService;
import me.gabreuw.spring_boot_jpa_pt_2.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Anime>> findAll() {
        return ResponseEntity
                .ok()
                .body(animeService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity
                .ok()
                .body(animeService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(
            @RequestBody AnimePostRequestBody animePostRequestBody
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(animeService.save(animePostRequestBody));
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
            @RequestBody AnimePutRequestBody animePutRequestBody
    ) {
        animeService.update(animePutRequestBody);

        return ResponseEntity
                .noContent()
                .build();
    }

}
