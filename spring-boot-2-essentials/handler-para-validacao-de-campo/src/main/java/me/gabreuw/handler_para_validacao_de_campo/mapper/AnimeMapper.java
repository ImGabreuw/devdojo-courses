package me.gabreuw.handler_para_validacao_de_campo.mapper;

import me.gabreuw.handler_para_validacao_de_campo.domain.Anime;
import me.gabreuw.handler_para_validacao_de_campo.request.AnimePostRequestBody;
import me.gabreuw.handler_para_validacao_de_campo.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}
