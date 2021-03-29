package me.gabreuw.framework_de_mapeamento_mapstruct.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

}
