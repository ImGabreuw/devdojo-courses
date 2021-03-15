package me.gabreuw.metodo_get_parte1.service;

import me.gabreuw.metodo_get_parte1.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

//    @Autowired
//    private AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return List.of(
                new Anime(1L, "DB2"),
                new Anime(2L, "Berserk")
        );
    }

}
