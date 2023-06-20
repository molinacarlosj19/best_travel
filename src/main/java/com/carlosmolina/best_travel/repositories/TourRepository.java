package com.carlosmolina.best_travel.repositories;

import com.carlosmolina.best_travel.domain.entities.FlyEntity;
import com.carlosmolina.best_travel.domain.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<TourEntity, Long> {

}
