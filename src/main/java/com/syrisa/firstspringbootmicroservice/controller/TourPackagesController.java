package com.syrisa.firstspringbootmicroservice.controller;

import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import com.syrisa.firstspringbootmicroservice.service.TourPackageService;
import com.syrisa.firstspringbootmicroservice.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TourPackagesController {

    private final TourPackageService tourPackageService;
    private final TourService tourService;


}
