package com.taslitsky.builder;

import com.taslitsky.model.Drink;
import com.taslitsky.model.Lunch;
import com.taslitsky.model.Order;

public class OrderBuilder implements Builder {
  private final Order order = new Order();

  public OrderBuilder lunch(Lunch lunch) {
    order.setLunch(lunch);
    Float dessertPrice = lunch.getDesertItem().getPrice();
    Float coursePrice = lunch.getCourseItem().getPrice();
    order.setPrice(order.getPrice() + dessertPrice + coursePrice);
    return this;
  }

  public OrderBuilder drink(Drink drink) {
    order.setDrink(drink);
    Float drinkPrice = drink.getDrinkItem().getPrice();
    order.setPrice(order.getPrice() + drinkPrice);
    return this;
  }

  public Order build() {
    return order;
  }
}
