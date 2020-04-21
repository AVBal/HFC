package com.flowers.flower.dao;

import com.flowers.flower.entities.Flower;
import org.springframework.data.repository.CrudRepository;

public interface FlowerRepository extends CrudRepository<Flower, Long> {
}
