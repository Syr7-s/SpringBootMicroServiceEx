package com.syrisa.firstspringbootmicroservice.service;

import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import com.syrisa.firstspringbootmicroservice.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    public TourPackage createTourPackage(String code,String name){


        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code,name)));
    }

    public Iterable<TourPackage> loogUp(){return tourPackageRepository.findAll();}

    public long total(){return tourPackageRepository.count();}
}
