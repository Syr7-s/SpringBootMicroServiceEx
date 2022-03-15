package com.syrisa.firstspringbootmicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends CrudRepository<TourRepository,Integer> {
}
