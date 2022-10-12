package com.taslitsky.repository;

import com.taslitsky.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
  private final List<Order> orders = new ArrayList<>();

  public List<Order> findAll() {
    return orders;
  }

  public void save(Order order) {
    orders.add(order);
  }
}
