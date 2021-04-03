package me.gabreuw.handler_para_validacao_de_campo.resporitory;

import me.gabreuw.handler_para_validacao_de_campo.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findByName(String name);

}