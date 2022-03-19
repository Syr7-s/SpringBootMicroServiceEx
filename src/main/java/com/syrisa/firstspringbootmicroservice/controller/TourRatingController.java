package com.syrisa.firstspringbootmicroservice.controller;

import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import com.syrisa.firstspringbootmicroservice.dto.RatingDto;
import com.syrisa.firstspringbootmicroservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/v1/tours/{tourId}/ratings")
@RequiredArgsConstructor
public class TourRatingController {
    private final RatingService ratingService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TourRating createTourRating(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        try {
            return ratingService.createTourRating(tourId, ratingDto);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }


    @GetMapping
    public List<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId) {
        try {
            return ratingService.getAllRatingsForTour(tourId);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }


    @GetMapping(path = "/average")
    public Map<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {
        try {
            return ratingService.getAverage(tourId);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException exception) {
        return exception.getMessage();
    }
}
