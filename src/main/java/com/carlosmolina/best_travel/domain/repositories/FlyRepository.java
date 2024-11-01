package com.carlosmolina.best_travel.domain.repositories;

import com.carlosmolina.best_travel.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface FlyRepository extends JpaRepository<FlyEntity, Long> {

    @Query("select f from fly f where f.price < :price")
    Set<FlyEntity> selectLessPrice(BigDecimal price);

    @Query("select f from fly f where f.price between :minPrice and :maxPrice")
    Set<FlyEntity> selectBetweenPrice(BigDecimal minPrice, BigDecimal maxPrice);

    @Query("select f from fly f where f.originName = :origin and f.destinyName = :destiny")
    Set<FlyEntity> selectOrigingDestiny(String origin, String destiny);

    @Query("select f from fly f join fetch f.tickets t where t.id = :id")
    Optional<FlyEntity> findByTicketId(UUID id);
}
