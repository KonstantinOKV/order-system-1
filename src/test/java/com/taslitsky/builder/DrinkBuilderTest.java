package com.taslitsky.builder;

import com.taslitsky.model.Drink;
import com.taslitsky.data.drink.DrinkAdditionItem;
import com.taslitsky.data.drink.DrinkItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DrinkBuilderTest {
  private DrinkBuilder underTest = new DrinkBuilder();

  @Test
  void drinkNotNullTest() {
    Assertions.assertNotNull(underTest.build());
  }

  @Test
  void drinkTest() {
    // GIVEN
    Drink expected = new Drink();
    expected.setDrinkItem(DrinkItem.PEPSI);

    // WHEN
    Drink actual = underTest.drink(DrinkItem.PEPSI)
        .build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void additionItemTest() {
    // GIVEN
    Drink expected = new Drink();
    expected.getAdditionItems().add(DrinkAdditionItem.LEMON);

    // WHEN
    Drink actual = underTest.additionItem(DrinkAdditionItem.LEMON)
        .build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void buildTest() {
    // GIVEN
    Drink expected = new Drink();

    // WHEN
    Drink actual = underTest.build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }
}