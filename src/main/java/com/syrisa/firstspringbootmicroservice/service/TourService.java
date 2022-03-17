package com.syrisa.firstspringbootmicroservice.service;

import com.syrisa.firstspringbootmicroservice.domain.Difficulty;
import com.syrisa.firstspringbootmicroservice.domain.Region;
import com.syrisa.firstspringbootmicroservice.domain.Tour;
import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import com.syrisa.firstspringbootmicroservice.repository.TourPackageRepository;
import com.syrisa.firstspringbootmicroservice.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;



    public Tour createTour(Tour tour) {
        TourPackage tourPackage = tourPackageRepository.
                findById(
                        tour.getTourPackage().getName())
                .orElseThrow(() -> new RuntimeException("Tour package does not exist :: " + tour.getTourPackage().getName()));
        tour.setTourPackage(tourPackage);
        return tourRepository.save(tour);
    }

/*
    public Tour createTour(String title, String description, String blurb,
                           Integer price, String duration, String bullets,
                           String keywords, String tourPackageName,
                           Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.
                findByName(
                        tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour package does not exist :: " + tourPackageName));

        return tourRepository.save(new Tour(title,description,blurb,price,duration,bullets,keywords,tourPackage,difficulty,region));
    }*/
    public long total() {
        return tourRepository.count();
    }
}
