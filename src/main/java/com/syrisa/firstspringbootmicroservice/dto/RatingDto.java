package com.syrisa.firstspringbootmicroservice.dto;

import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@Builder
public class RatingDto {
    @Min(0)
    @Max(5)
    private Integer score;
    
    @Size(max=255)
    private String comment;

    @NotNull
    private Integer customerId;

    public RatingDto(TourRating tourRating) {
        this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerID());
    }

    private RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    protected RatingDto() {}
}
