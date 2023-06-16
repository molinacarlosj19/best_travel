package com.carlosmolina.best_travel.repositories;

import com.carlosmolina.best_travel.domain.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

}
