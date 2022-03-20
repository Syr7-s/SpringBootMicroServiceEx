package com.syrisa.firstspringbootmicroservice.repository;

import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
@Repository
public interface TourRatingRepository extends CrudRepository<TourRating, String> {

    // List<TourRating> findByPkTourId(Integer tourId);
    List<TourRating> findByTourId(String tourId);

    //Optional<TourRating> findByPkTourIdAndPkCustomerID(Integer tourId, Integer customerId);

    Optional<TourRating> findByTourIdAndCustomerId(String tourId, Integer customerId);

    //Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);
    Page<TourRating> findByTourId(String tourId, Pageable pageable);
}
