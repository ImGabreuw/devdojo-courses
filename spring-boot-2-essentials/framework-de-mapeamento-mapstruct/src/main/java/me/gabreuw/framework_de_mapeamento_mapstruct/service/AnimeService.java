package me.gabreuw.framework_de_mapeamento_mapstruct.service;

import me.gabreuw.framework_de_mapeamento_mapstruct.domain.Anime;
import me.gabreuw.framework_de_mapeamento_mapstruct.mapper.AnimeMapper;
import me.gabreuw.framework_de_mapeamento_mapstruct.request.AnimePostRequestBody;
import me.gabreuw.framework_de_mapeamento_mapstruct.request.AnimePutRequestBody;
import me.gabreuw.framework_de_mapeamento_mapstruct.resporitory.AnimeRepository;
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
