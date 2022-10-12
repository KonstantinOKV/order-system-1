package com.taslitsky.builder;

import com.taslitsky.model.Drink;
import com.taslitsky.data.drink.DrinkAdditionItem;
import com.taslitsky.data.drink.DrinkItem;

public class DrinkBuilder implements Builder {
  private final Drink drink = new Drink();

  public DrinkBuilder drink(DrinkItem drinkItem) {
    drink.setDrinkItem(drinkItem);
    return this;
  }

  public DrinkBuilder additionItem(DrinkAdditionItem additionalItem) {
    drink.getAdditionItems().add(additionalItem);
    return this;
  }

  public Drink build() {
    return drink;
  }
}
