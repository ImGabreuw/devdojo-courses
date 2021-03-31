package me.gabreuw.framework_de_mapeamento_mapstruct.resporitory;

import me.gabreuw.framework_de_mapeamento_mapstruct.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {}