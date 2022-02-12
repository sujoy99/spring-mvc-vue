package com.infoworks.lab.services.helper;


import com.infoworks.lab.domain.dto.OrderDTO;
import com.infoworks.lab.domain.entities.Order;
import com.infoworks.lab.domain.entities.OrderDetail;
import com.infoworks.lab.domain.entities.Pizza;
import com.infoworks.lab.domain.entities.Toppings;
import com.infoworks.lab.services.PizzaService;
import com.infoworks.lab.services.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderHelper {

    private final ToppingsService toppingsService;
    private final PizzaService pizzaService;

    public void setOrderDetails(OrderDTO orderDTO, Order order) {
        Pizza pizza = pizzaService.findById(orderDTO.getPizzaId()).get();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Arrays.asList(orderDTO.getToppingsId()).forEach(toppingsId -> {
            Toppings toppings = toppingsService.findById(toppingsId).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPizza(pizza);
            orderDetail.setToppings(toppings);
            orderDetails.add(orderDetail);
        });
        order.setOrderDetails(orderDetails);
    }

    public void updateOrderDetails(OrderDTO orderDTO, Order order) {
        order.getOrderDetails().clear();
        Pizza pizza = pizzaService.findById(orderDTO.getPizzaId()).get();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Arrays.asList(orderDTO.getToppingsId()).forEach(toppingsId -> {
            Toppings toppings = toppingsService.findById(toppingsId).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPizza(pizza);
            orderDetail.setToppings(toppings);
            orderDetails.add(orderDetail);
        });
        order.getOrderDetails().addAll(orderDetails);
    }
}
