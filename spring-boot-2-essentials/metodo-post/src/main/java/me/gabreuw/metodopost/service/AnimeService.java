package me.gabreuw.metodopost.service;

import me.gabreuw.metodopost.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static final List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(
                new Anime(1L, "DB2"),
                new Anime(2L, "Berserk")
        ));
    }

//    @Autowired
//    private AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(Long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Anime not found.")
                );
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1_000_000L));

        animes.add(anime);

        return anime;
    }
}
