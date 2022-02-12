package com.infoworks.lab.services;

import com.infoworks.lab.domain.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(Long orderId);

    void saveOrder(Order order);
}
