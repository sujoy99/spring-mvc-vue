package com.infoworks.lab.services;

import com.infoworks.lab.domain.entities.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    List<Pizza> findAll();

    Optional<Pizza> findById(Long pizzaId);

    void savePizza(Pizza pizza);
}
