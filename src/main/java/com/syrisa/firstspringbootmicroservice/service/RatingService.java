package com.syrisa.firstspringbootmicroservice.service;

import com.syrisa.firstspringbootmicroservice.domain.Tour;
import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import com.syrisa.firstspringbootmicroservice.domain.TourRatingPk;
import com.syrisa.firstspringbootmicroservice.dto.RatingDto;
import com.syrisa.firstspringbootmicroservice.repository.TourRatingRepository;
import com.syrisa.firstspringbootmicroservice.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RatingService {
    private final TourRatingRepository tourRatingRepository;
    private final TourRepository tourRepository;

    public TourRating createTourRating(int tourId, RatingDto ratingDto) {
        Tour tour = verifyTour(tourId);
        return tourRatingRepository.save(new TourRating(
                new TourRatingPk(tour, ratingDto.getCustomerId())
                , ratingDto.getScore(), ratingDto.getComment()));
    }

    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("Tour does not exist " + tourId));
    }

    public List<RatingDto> getAllRatingsForTour(int tourId) {
        verifyTour(tourId);
        return tourRatingRepository.findByPkTourId(tourId).stream()
                .map(RatingDto::new).collect(Collectors.toList());
    }

    public Map<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {
        verifyTour(tourId);
        return Map.of("average", tourRatingRepository.findByPkTourId(tourId).stream()
                .mapToInt(TourRating::getScore).average()
                .orElseThrow(() ->
                        new NoSuchElementException("Tour has no Ratings")));
    }
}
