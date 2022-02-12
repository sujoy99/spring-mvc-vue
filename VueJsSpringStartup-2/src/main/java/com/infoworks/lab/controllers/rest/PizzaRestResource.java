package com.infoworks.lab.controllers.rest;

import com.infoworks.lab.domain.entities.Pizza;
import com.infoworks.lab.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pizza")
public class PizzaRestResource {

    private final PizzaService pizzaService;

    @GetMapping(value = "/find/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> findById(@PathVariable("id") Long toppingsId) {

        try {
            return new ResponseEntity<Pizza>(pizzaService.findById(toppingsId).orElseThrow(() -> new RuntimeException("Not found")), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Pizza>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pizza>> findAll() {

        try {
            List<Pizza> pizzas = pizzaService.findAll();
            return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Pizza>>(HttpStatus.BAD_REQUEST);
        }
    }
}
