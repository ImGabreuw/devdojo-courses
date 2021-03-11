package me.gabreuw.criandoprojetonapedreiragempt01.resource;

import me.gabreuw.criandoprojetonapedreiragempt01.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "anime")
public class AnimeResource {

    @GetMapping(path = "list")
    public List<Anime> list() {
        return List.of(
                new Anime("DB2"),
                new Anime("Berserk")
        );
    }

}
