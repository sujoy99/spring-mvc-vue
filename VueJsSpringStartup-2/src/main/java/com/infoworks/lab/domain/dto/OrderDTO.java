package com.infoworks.lab.domain.dto;

import com.infoworks.lab.domain.entities.Order;
import com.infoworks.lab.domain.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.infoworks.lab.domain.enums.Status.PENDING;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;
    private Long pizzaId;
    private Double totalPrice = 0.00;
    private Status status = PENDING;
    private Long[] toppingsId;

    public Order toEntity() {
        Order order = new Order();
        order.setOrderStatus(status);
        order.setTotalPrice(totalPrice);
        return order;
    }

    public Order updateEntity(Order order) {
        order.setOrderStatus(status);
        order.setTotalPrice(totalPrice);
        return order;
    }
}
