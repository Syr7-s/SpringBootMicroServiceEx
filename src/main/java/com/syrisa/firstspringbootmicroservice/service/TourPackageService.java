package com.syrisa.firstspringbootmicroservice.service;

import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import com.syrisa.firstspringbootmicroservice.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    public TourPackage createTourPackage(TourPackage tourPackage){

        return tourPackageRepository.findById(tourPackage.getCode())
                .orElse(tourPackageRepository.save(tourPackage));
    }

    public Iterable<TourPackage> loogUp(){return tourPackageRepository.findAll();}

    public long total(){return tourPackageRepository.count();}
}
