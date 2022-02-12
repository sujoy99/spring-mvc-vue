package com.infoworks.lab.domain.decorator.decor;

import com.infoworks.lab.domain.decorator.myPizza.iPizza;
import com.infoworks.lab.domain.entities.Toppings;

public class ToppingsImpl implements PizzaDecorator {

    private final iPizza pizzaDecor;

    private Double toppingsPrice = 0.0d;

    public ToppingsImpl(iPizza pizzaDecor, Toppings toppingsDecor) {
        this.pizzaDecor = pizzaDecor;
        toppingsPrice = pizzaDecor.getCost() + toppingsDecor.getToppingPrice();
    }

    /*public ToppingsImpl(PizzaDecor pizzaDecor, Double toppingsPrice) {
        this.pizzaDecor = pizzaDecor;
//        this.toppingsPrice = pizzaDecor.getCost() ;
    }*/

    @Override
    public String getDescription() {
        return pizzaDecor.getDescription();
    }

    @Override
    public Double getCost() {
        return toppingsPrice;
    }

    public Double totalCost(Double toppingsPrice) {
        return getCost() + toppingsPrice;
    }
}
