package com.taslitsky.repository;

import com.taslitsky.builder.DrinkBuilder;
import com.taslitsky.builder.LunchBuilder;
import com.taslitsky.builder.OrderBuilder;
import com.taslitsky.data.drink.DrinkAdditionItem;
import com.taslitsky.data.drink.DrinkItem;
import com.taslitsky.data.lunch.polishlunch.PolishCourseItem;
import com.taslitsky.data.lunch.polishlunch.PolishDessertItem;
import com.taslitsky.model.Drink;
import com.taslitsky.model.Lunch;
import com.taslitsky.model.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderRepoTest {
  private OrderRepo underTest = new OrderRepo();

  @Test
  void saveTest() {
    // GIVEN
    List<Order> expected = new ArrayList<>();
    Order order = createFullOrder();
    expected.add(order);

    // WHEN
    underTest.save(order);

    // THEN
    Assertions.assertEquals(expected, underTest.findAll());
  }

  @Test
  void findAllTest() {
    // GIVEN
    List<Order> expected = new ArrayList<>();
    Order order = createOrderWithLunchOnly();
    expected.add(order);
    underTest.save(order);

    order = createFullOrder();
    expected.add(order);
    underTest.save(order);

    // WHEN
    List<Order> actual = underTest.findAll();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  private Order createFullOrder() {
    Lunch lunch = new LunchBuilder()
        .course(PolishCourseItem.POLISH_CHICKEN)
        .dessert(PolishDessertItem.POLISH_CAKE)
        .build();
    Drink drink = new DrinkBuilder()
        .drink(DrinkItem.PEPSI)
        .additionItem(DrinkAdditionItem.LEMON)
        .build();
    return new OrderBuilder()
        .drink(drink)
        .lunch(lunch)
        .build();
  }

  private Order createOrderWithLunchOnly() {
    Lunch lunch = new LunchBuilder()
        .course(PolishCourseItem.POLISH_CHICKEN)
        .dessert(PolishDessertItem.POLISH_CAKE)
        .build();

    return new OrderBuilder()
        .lunch(lunch)
        .build();
  }
}