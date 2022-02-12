package com.infoworks.lab.domain.repositories;

import com.infoworks.lab.domain.entities.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Long> {
}
