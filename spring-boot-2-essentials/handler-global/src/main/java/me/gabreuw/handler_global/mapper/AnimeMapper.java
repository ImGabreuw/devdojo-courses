package me.gabreuw.handler_global.mapper;

import me.gabreuw.handler_global.domain.Anime;
import me.gabreuw.handler_global.request.AnimePostRequestBody;
import me.gabreuw.handler_global.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
