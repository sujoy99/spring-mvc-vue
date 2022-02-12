package com.infoworks.lab.domain.repositories;

import com.infoworks.lab.domain.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
