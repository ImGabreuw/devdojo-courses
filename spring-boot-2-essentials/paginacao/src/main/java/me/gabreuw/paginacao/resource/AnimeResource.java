package me.gabreuw.paginacao.resource;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.paginacao.domain.Anime;
import me.gabreuw.paginacao.request.AnimePostRequestBody;
import me.gabreuw.paginacao.request.AnimePutRequestBody;
import me.gabreuw.paginacao.service.AnimeService;
import me.gabreuw.paginacao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Page<Anime>> list(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(animeService.findAll(pageable));
    }

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

    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>> findByName(
            @RequestParam String name
    ) {
        return ResponseEntity
                .ok()
                .body(animeService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Anime> save(
            @RequestBody @Valid AnimePostRequestBody animePostRequestBody
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
