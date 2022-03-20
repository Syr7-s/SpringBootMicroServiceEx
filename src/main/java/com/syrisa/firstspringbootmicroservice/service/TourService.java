package com.syrisa.firstspringbootmicroservice.service;

import com.syrisa.firstspringbootmicroservice.domain.Tour;
import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import com.syrisa.firstspringbootmicroservice.repository.TourPackageRepository;
import com.syrisa.firstspringbootmicroservice.repository.TourRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    public Tour createTour(Tour tour) {
        TourPackage tourPackage = tourPackageRepository.findByName(tour.getTourPackageName()).orElseThrow(()->
                new RuntimeException("Tour package does not exist :: " + tour.getTourPackageName()));
        tour.setTourPackage(tourPackage);
        return tourRepository.save(tour);
    }


    public long total() {
        return tourRepository.count();
    }


}
