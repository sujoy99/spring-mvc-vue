package com.infoworks.lab.controllers.rest;

import com.infoworks.lab.domain.decorator.decor.ToppingsImpl;
import com.infoworks.lab.domain.decorator.myPizza.PizzaImpl;
import com.infoworks.lab.domain.decorator.myPizza.iPizza;
import com.infoworks.lab.domain.dto.DataDTO;
import com.infoworks.lab.domain.entities.Pizza;
import com.infoworks.lab.domain.entities.Toppings;
import com.infoworks.lab.services.PizzaService;
import com.infoworks.lab.services.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/toppings")
public class ToppingsRestResource {

    private final ToppingsService toppingsService;
    private final PizzaService pizzaService;

    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Toppings> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Toppings>(toppingsService.findById(toppingsId).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Toppings>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/find/{id}/{pizzaId}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> findById(@PathVariable("id") Long toppingsId, @PathVariable("pizzaId") Long pizzaId) {

        try {

//            PizzaDecor pizzaDecor = new PizzaImpl(1L, "pizza1", 100.0);
//            ToppingsImpl toppings = new ToppingsImpl(pizzaDecor, 30.0);

            Pizza pizza = pizzaService.findById(pizzaId).get();
            iPizza pizzaDecor = new PizzaImpl(pizza);
            Toppings toppingsEntity = toppingsService.findById(toppingsId).get();
            ToppingsImpl toppings = new ToppingsImpl(pizzaDecor, toppingsEntity);

            return new ResponseEntity<Double>(toppings.getCost(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> findBy(@RequestBody DataDTO data) {

        try {

            Pizza pizza = pizzaService.findById(data.getPizzaId()).get();
            iPizza pizzaDecor = new PizzaImpl(pizza);

            for (Long id :
                    data.getToppingsId()) {
                Toppings toppingsEntity = toppingsService.findById(id).get();
                pizzaDecor = new ToppingsImpl(pizzaDecor, toppingsEntity);
            }
            return new ResponseEntity<Double>(pizzaDecor.getCost(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Toppings>> findAll() {

        try {
            List<Toppings> toppings = toppingsService.findAll();
            return new ResponseEntity<List<Toppings>>(toppings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Toppings>>(HttpStatus.BAD_REQUEST);
        }
    }
}
