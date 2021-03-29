package me.gabreuw.framework_de_mapeamento_mapstruct.mapper;

import me.gabreuw.framework_de_mapeamento_mapstruct.domain.Anime;
import me.gabreuw.framework_de_mapeamento_mapstruct.request.AnimePostRequestBody;
import me.gabreuw.framework_de_mapeamento_mapstruct.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
