package me.gabreuw.spring_boot_jpa_pt_2.service;

import me.gabreuw.spring_boot_jpa_pt_2.domain.Anime;
import me.gabreuw.spring_boot_jpa_pt_2.request.AnimePostRequestBody;
import me.gabreuw.spring_boot_jpa_pt_2.request.AnimePutRequestBody;
import me.gabreuw.spring_boot_jpa_pt_2.resporitory.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(Long id) {
        return animeRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Anime not found.")
                );
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime
                .builder()
                .name(animePostRequestBody.getName())
                .build()
        );
    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());

        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(anime);
    }
}
