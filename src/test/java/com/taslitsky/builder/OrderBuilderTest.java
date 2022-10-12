package com.taslitsky.builder;

import com.taslitsky.data.drink.DrinkItem;
import com.taslitsky.data.lunch.italianlunch.ItalianCourseItem;
import com.taslitsky.data.lunch.italianlunch.ItalianDessertItem;
import com.taslitsky.model.Drink;
import com.taslitsky.model.Lunch;
import com.taslitsky.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderBuilderTest {

  private OrderBuilder underTest = new OrderBuilder();

  @Test
  void orderNotNullTest() {
    Assertions.assertNotNull(underTest.build());
  }

  @Test
  void lunchTest() {
    // GIVEN
    Lunch lunch = new LunchBuilder()
        .course(ItalianCourseItem.ITALIAN_CHICKEN)
        .dessert(ItalianDessertItem.ITALIAN_CAKE)
        .build();

    Order expected = new Order();
    expected.setLunch(lunch);
    expected.setPrice(lunch.getPrice());

    // WHEN
    Order actual = underTest
        .lunch(lunch)
        .build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void drinkTest() {
    Drink drink = new DrinkBuilder()
        .drink(DrinkItem.PEPSI)
        .build();

    Order expected = new Order();
    expected.setDrink(drink);
    expected.setPrice(drink.getDrinkItem().getPrice());

    // WHEN
    Order actual = underTest
        .drink(drink)
        .build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void buildTest() {
    // GIVEN
    Order expected = new Order();

    // WHEN
    Order actual = underTest.build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }
}