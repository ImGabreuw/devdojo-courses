package me.gabreuw.instalando_docker_e_executando_container_mysql.resporitory;

import me.gabreuw.instalando_docker_e_executando_container_mysql.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
