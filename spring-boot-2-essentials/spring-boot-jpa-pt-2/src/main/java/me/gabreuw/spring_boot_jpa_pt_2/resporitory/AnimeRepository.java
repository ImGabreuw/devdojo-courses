package me.gabreuw.spring_boot_jpa_pt_2.resporitory;

import me.gabreuw.spring_boot_jpa_pt_2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {}