package me.gabreuw.sobrescrevendohandlerdospring.mapper;

import me.gabreuw.sobrescrevendohandlerdospring.domain.Anime;
import me.gabreuw.sobrescrevendohandlerdospring.request.AnimePostRequestBody;
import me.gabreuw.sobrescrevendohandlerdospring.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
