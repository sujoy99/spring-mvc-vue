package com.infoworks.lab.services.implementation;

import com.infoworks.lab.domain.entities.Pizza;
import com.infoworks.lab.domain.repositories.PizzaRepository;
import com.infoworks.lab.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Optional<Pizza> findById(Long pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @Override
    @Transactional
    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

}
