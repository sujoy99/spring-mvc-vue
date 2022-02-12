package com.infoworks.lab.webapp;

import com.infoworks.lab.domain.entities.Pizza;
import com.infoworks.lab.domain.entities.Toppings;
import com.infoworks.lab.domain.repositories.PizzaRepository;
import com.infoworks.lab.domain.repositories.ToppingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.infoworks.lab.controllers"
        , "com.infoworks.lab.services"
        , "com.infoworks.lab.webapp.config"
        , "com.infoworks.lab.domain"})
@RequiredArgsConstructor
public class VueAppServices extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingsRepository toppingsRepository;

    public static void main(String[] args) {
        SpringApplication.run(VueAppServices.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VueAppServices.class);
    }

    @Override
    public void run(String... args) throws Exception {

        Toppings toppingsOne = new Toppings(1L, "Sausage", 30.0);
        Toppings toppingsTwo = new Toppings(2L, "Mushroom", 40.0);
        Toppings toppingsThree = new Toppings(3L, "Peeperoni", 60.0);

        toppingsRepository.saveAll(Arrays.asList(toppingsOne, toppingsTwo, toppingsThree));

        Pizza pizzaOne = new Pizza(1L, "ThickCrustPizza", 500.0);
        Pizza pizzaTwo = new Pizza(2L, "ThinCrustPizza", 400.0);
        Pizza pizzaThree = new Pizza(3L, "CheeseCrustPizza", 600.0);

        pizzaRepository.saveAll(Arrays.asList(pizzaOne, pizzaTwo, pizzaThree));
    }
}

