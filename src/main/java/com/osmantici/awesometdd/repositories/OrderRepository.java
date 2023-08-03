package com.osmantici.awesometdd.repositories;

import com.osmantici.awesometdd.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
