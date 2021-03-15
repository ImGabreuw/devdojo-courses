package me.gabreuw.gerando_projeto_com_start_spring_io.resource;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.gerando_projeto_com_start_spring_io.domain.Anime;
import me.gabreuw.gerando_projeto_com_start_spring_io.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "anime")
@Log4j2
public class AnimeResource {

    @Autowired
    private DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyles(LocalDateTime.now()));
        return List.of(
                new Anime("DB2"),
                new Anime("Berserk")
        );
    }

}
