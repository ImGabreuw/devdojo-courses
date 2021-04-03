package me.gabreuw.sobrescrevendohandlerdospring.service;

import me.gabreuw.sobrescrevendohandlerdospring.domain.Anime;
import me.gabreuw.sobrescrevendohandlerdospring.exception.BadRequestException;
import me.gabreuw.sobrescrevendohandlerdospring.mapper.AnimeMapper;
import me.gabreuw.sobrescrevendohandlerdospring.request.AnimePostRequestBody;
import me.gabreuw.sobrescrevendohandlerdospring.request.AnimePutRequestBody;
import me.gabreuw.sobrescrevendohandlerdospring.resporitory.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
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
