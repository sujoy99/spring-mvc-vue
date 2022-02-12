package com.infoworks.lab.services.implementation;

import com.infoworks.lab.domain.entities.Order;
import com.infoworks.lab.domain.repositories.OrderRepository;
import com.infoworks.lab.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
