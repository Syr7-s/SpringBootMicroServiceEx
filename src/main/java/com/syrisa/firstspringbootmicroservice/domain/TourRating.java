package com.syrisa.firstspringbootmicroservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourRating {

    @EmbeddedId
    private TourRatingPk pk;

    @Column(nullable=false)
    private Integer score;

    @Column
    private String comment;


}
