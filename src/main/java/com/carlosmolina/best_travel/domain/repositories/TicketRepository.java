package com.carlosmolina.best_travel.domain.repositories;

import com.carlosmolina.best_travel.domain.entities.FlyEntity;
import com.carlosmolina.best_travel.domain.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, UUID> {
}
