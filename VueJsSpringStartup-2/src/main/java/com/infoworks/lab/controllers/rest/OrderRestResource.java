package com.infoworks.lab.controllers.rest;

import com.infoworks.lab.domain.entities.Order;
import com.infoworks.lab.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
public class OrderRestResource {

    private final OrderService orderService;


    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Order>(orderService.findById(toppingsId).orElseThrow(() -> new RuntimeException("Not found")), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
    }

    /*@PostMapping("/save-order")
    public String savePizza(OrderDTO orderDTO) {

        Order order = orderDTO.toEntity();
        orderHelper.setOrderDetails(orderDTO, order);
        orderService.saveOrder(order);

        return "redirect:/";
    }*/
}
