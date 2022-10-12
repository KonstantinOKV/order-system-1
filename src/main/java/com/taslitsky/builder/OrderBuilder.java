package com.taslitsky.builder;

import com.taslitsky.model.Drink;
import com.taslitsky.model.Lunch;
import com.taslitsky.model.Order;

public class OrderBuilder implements Builder {
  private final Order order = new Order();

  /**
   * @param lunch - lunch model.
   * @return orderBuilder instance.
   */
  public OrderBuilder lunch(Lunch lunch) {
    order.setLunch(lunch);
    Float dessertPrice = lunch.getDessertItem().getPrice();
    Float coursePrice = lunch.getCourseItem().getPrice();
    order.setPrice(order.getPrice() + dessertPrice + coursePrice);
    return this;
  }

  /**
   * @param drink - drink model.
   * @return orderBuilder instance.
   */
  public OrderBuilder drink(Drink drink) {
    order.setDrink(drink);
    Float drinkPrice = drink.getDrinkItem().getPrice();
    order.setPrice(order.getPrice() + drinkPrice);
    return this;
  }

  /**
   * @return built order.
   */
  public Order build() {
    return order;
  }
}
