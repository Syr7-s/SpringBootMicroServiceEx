package com.syrisa.firstspringbootmicroservice.service;

import com.syrisa.firstspringbootmicroservice.domain.Tour;
import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import com.syrisa.firstspringbootmicroservice.repository.TourRatingRepository;
import com.syrisa.firstspringbootmicroservice.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class TourRatingService {
    private final TourRatingRepository tourRatingRepository;
    private final TourRepository tourRepository;

    public TourRating createTourRating(String tourId, TourRating tourRating) {
        Tour tour = verifyTour(tourId);
        return tourRatingRepository.save(new TourRating(
                tourId, tourRating.getCustomerId(),
                tourRating.getScore(), tourRating.getComment()));
    }

    private Tour verifyTour(String tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("Tour does not exist " + tourId));
    }

    public Page<TourRating> getAllRatingsForTour(String tourId, Pageable pageable) {
        verifyTour(tourId);
      /*  return tourRatingRepository.findByPkTourId(tourId).stream()
                .map(RatingDto::new).collect(Collectors.toList());*/
    /*    Page<TourRating> ratings = tourRatingRepository.findByTourId(tourId, pageable);
        return new PageImpl<>(
                ratings.get().map(RatingDto::new)
                        .collect(Collectors.toList()),
                pageable, ratings.getTotalElements()
        );*/
        return tourRatingRepository.findByTourId(tourId, pageable);
    }

    public Map<String, Double> getAverage(String tourId) {
        verifyTour(tourId);
        return Map.of("average", tourRatingRepository.findByTourId(tourId).stream()
                .mapToInt(TourRating::getScore).average()
                .orElseThrow(() ->
                        new NoSuchElementException("Tour has no Ratings")));
    }

    public TourRating updateWithPut(String tourId, TourRating tourRating) {
        TourRating rating = verifyTourRating(tourId, tourRating.getCustomerId());
        rating.setScore(rating.getScore());
        rating.setComment(rating.getComment());
        return tourRatingRepository.save(rating);
    }

    public TourRating updateWithPatch(String tourId, TourRating tourRating) {
        TourRating rating = verifyTourRating(tourId, tourRating.getCustomerId());
        if (tourRating.getScore() != null) {
            rating.setScore(tourRating.getScore());
        }
        if (tourRating.getComment() != null) {
            rating.setComment(tourRating.getComment());
        }
      return tourRatingRepository.save(rating);
    }

    public void delete(String tourId, int customerId) {
        TourRating rating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(rating);
    }

    private TourRating verifyTourRating(String tourId, int customerId) throws NoSuchElementException {
        return tourRatingRepository.findByTourIdAndCustomerId(tourId, customerId)
                .orElseThrow(() ->
                        new NoSuchElementException(("Tour Rating pair for reguest " + tourId + " for customer " + customerId)));
    }

}
