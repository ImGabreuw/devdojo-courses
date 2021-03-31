package me.gabreuw.excecoes_customizadas.service;

import me.gabreuw.excecoes_customizadas.domain.Anime;
import me.gabreuw.excecoes_customizadas.exception.BadRequestException;
import me.gabreuw.excecoes_customizadas.mapper.AnimeMapper;
import me.gabreuw.excecoes_customizadas.request.AnimePostRequestBody;
import me.gabreuw.excecoes_customizadas.request.AnimePutRequestBody;
import me.gabreuw.excecoes_customizadas.resporitory.AnimeRepository;
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

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(Long id) {
        return animeRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found."));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(
                AnimeMapper.INSTANCE.toAnime(animePostRequestBody)
        );
    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void update(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);

        anime.setId(savedAnime.getId());

        animeRepository.save(anime);
    }
}
