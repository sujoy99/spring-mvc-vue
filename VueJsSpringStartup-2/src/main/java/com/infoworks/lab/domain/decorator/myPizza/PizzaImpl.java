package com.infoworks.lab.domain.decorator.myPizza;

import com.infoworks.lab.domain.entities.Pizza;

public class PizzaImpl implements iPizza {

    private final Pizza pizza;

    public PizzaImpl(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getPizzaName();
    }

    @Override
    public Double getCost() {
        return pizza.getPizzaPrice();
    }

    public Pizza toEntity() {
        return pizza;
    }
}
