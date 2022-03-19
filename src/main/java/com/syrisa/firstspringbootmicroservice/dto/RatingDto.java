package com.syrisa.firstspringbootmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    @Min(0)
    @Max(5)
    private Integer score;
    
    @Size(max=255)
    private String comment;

    @NotNull
    private Integer customerId;
}
