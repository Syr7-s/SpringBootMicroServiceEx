package com.syrisa.firstspringbootmicroservice.repository;

import com.syrisa.firstspringbootmicroservice.domain.TourRating;
import com.syrisa.firstspringbootmicroservice.domain.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
@Repository
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    List<TourRating> findByPkTourId(Integer tourId);

    Optional<TourRating> findByPkTourIdAndPkCustomerID(Integer tourId,Integer customerId);
}
