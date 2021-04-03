package me.gabreuw.paginacao.mapper;

import me.gabreuw.paginacao.domain.Anime;
import me.gabreuw.paginacao.request.AnimePostRequestBody;
import me.gabreuw.paginacao.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
