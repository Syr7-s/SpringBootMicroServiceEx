package com.syrisa.firstspringbootmicroservice.controller;

import com.syrisa.firstspringbootmicroservice.domain.Tour;
import com.syrisa.firstspringbootmicroservice.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/tour")
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tour create(@RequestBody Tour tour){
        try{
            return tourService.createTour(tour);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }

    @GetMapping("/tourCount")
    public long count(){
        return tourService.total();
    }
}
