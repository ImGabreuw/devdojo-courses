package me.gabreuw.excecoes_customizadas.mapper;

import me.gabreuw.excecoes_customizadas.domain.Anime;
import me.gabreuw.excecoes_customizadas.request.AnimePostRequestBody;
import me.gabreuw.excecoes_customizadas.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
