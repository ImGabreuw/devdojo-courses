package me.gabreuw.trasacao.mapper;

import me.gabreuw.trasacao.domain.Anime;
import me.gabreuw.trasacao.request.AnimePostRequestBody;
import me.gabreuw.trasacao.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
