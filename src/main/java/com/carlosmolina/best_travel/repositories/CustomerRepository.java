package com.carlosmolina.best_travel.repositories;

import com.carlosmolina.best_travel.domain.entities.CustomerEntity;
import com.carlosmolina.best_travel.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {

}
