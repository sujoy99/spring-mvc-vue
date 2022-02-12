package com.infoworks.lab.domain.decorator.myPizza;

public interface iPizza {

    String getDescription();
    Double getCost();
//    default float convertCost() { return Float.valueOf(getCost().toPlainString()); }
//    default String printedCost() { return String.format("%.2f", convertCost()); }
}
