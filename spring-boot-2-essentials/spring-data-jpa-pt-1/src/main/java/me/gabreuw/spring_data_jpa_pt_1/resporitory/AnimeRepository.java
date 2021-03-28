package me.gabreuw.spring_data_jpa_pt_1.resporitory;

import me.gabreuw.spring_data_jpa_pt_1.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
