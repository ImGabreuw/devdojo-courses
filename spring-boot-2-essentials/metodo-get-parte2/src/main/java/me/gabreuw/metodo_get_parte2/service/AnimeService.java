package me.gabreuw.metodo_get_parte2.service;

import me.gabreuw.metodo_get_parte2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {
    private final List<Anime> anime = List.of(
            new Anime(1L, "DB2"),
            new Anime(2L, "Berserk")
    );

//    @Autowired
//    private AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return anime;
    }

    public Anime findById(Long id) {
        return anime.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Anime not found.")
                );
    }

}
