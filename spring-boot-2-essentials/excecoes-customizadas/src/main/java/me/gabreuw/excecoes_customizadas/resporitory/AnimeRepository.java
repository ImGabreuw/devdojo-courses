package me.gabreuw.excecoes_customizadas.resporitory;

import me.gabreuw.excecoes_customizadas.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findByName(String name);

}