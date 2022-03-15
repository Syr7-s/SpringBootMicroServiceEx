package com.syrisa.firstspringbootmicroservice.repository;

import com.syrisa.firstspringbootmicroservice.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPackageRepository extends CrudRepository<TourPackage,String> {
}
