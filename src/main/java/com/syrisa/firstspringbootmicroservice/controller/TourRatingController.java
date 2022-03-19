package com.syrisa.firstspringbootmicroservice.controller;

import com.syrisa.firstspringbootmicroservice.domain.Tour;
import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import com.syrisa.firstspringbootmicroservice.domain.TourRatingPk;
import com.syrisa.firstspringbootmicroservice.dto.RatingDto;
import com.syrisa.firstspringbootmicroservice.repository.TourRatingRepository;
import com.syrisa.firstspringbootmicroservice.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/v1/tours/{tourId}/ratings")
@RequiredArgsConstructor
public class TourRatingController {
    private final TourRatingRepository tourRatingRepository;
    private final TourRepository tourRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourıD") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        Tour tour = verifyTour(tourId);
        tourRatingRepository.save(new TourRating(
                new TourRatingPk(tour, ratingDto.getCustomerId())
                , ratingDto.getScore(), ratingDto.getComment()));
    }


    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("Tour does not exist " + tourId));
    }

    @GetMapping
    public List<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId) {
        verifyTour(tourId);
        return tourRatingRepository.findByPkTourId(tourId).stream()
                .map(RatingDto::new).collect(Collectors.toList());
    }


    @GetMapping(path = "/average")
    public Map<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {
        verifyTour(tourId);
        return Map.of("average", tourRatingRepository.findByPkTourId(tourId).stream()
                .mapToInt(TourRating::getScore).average()
                .orElseThrow(() ->
                        new NoSuchElementException("Tour has no Ratings")));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException exception) {
        return exception.getMessage();
    }
}
