package com.syrisa.firstspringbootmicroservice.controller;

import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import com.syrisa.firstspringbootmicroservice.service.TourPackageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tourPackage")
public class TourPackageController {
    private final TourPackageService tourPackageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TourPackage create(TourPackage tourPackage){
        try{
            return tourPackageService.createTourPackage(tourPackage);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/all")
    public Iterable<TourPackage> getAllTourPackages(){
        return tourPackageService.getAll();
    }

    @GetMapping("/totalCount")
    public long total(){
        return tourPackageService.total();
    }
}
