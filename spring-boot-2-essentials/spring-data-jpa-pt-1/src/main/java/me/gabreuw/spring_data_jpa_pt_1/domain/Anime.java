package me.gabreuw.spring_data_jpa_pt_1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

}
