package me.gabreuw.handler_global.service;

import me.gabreuw.handler_global.domain.Anime;
import me.gabreuw.handler_global.exception.BadRequestException;
import me.gabreuw.handler_global.mapper.AnimeMapper;
import me.gabreuw.handler_global.request.AnimePostRequestBody;
import me.gabreuw.handler_global.request.AnimePutRequestBody;
import me.gabreuw.handler_global.resporitory.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
