package ru.trofimom.coffeemakerrestservice.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.trofimom.coffeemakerrestservice.model.CoffeeMaker;

public interface CoffeeMakerRepository extends CrudRepository<CoffeeMaker, Long> {

    CoffeeMaker findTopByOrderByIdDesc();
}
