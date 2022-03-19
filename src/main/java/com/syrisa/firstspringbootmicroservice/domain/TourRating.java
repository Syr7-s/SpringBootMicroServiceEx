package com.syrisa.firstspringbootmicroservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourRating {

    @EmbeddedId
    private TourRatingPk pk;

    @Column(nullable=false)
    private Integer score;

    @Column
    private String comment;


}
