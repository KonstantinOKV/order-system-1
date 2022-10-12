package com.taslitsky.model;

import java.util.Objects;

public class Order {
  private Lunch lunch;
  private Drink drink;
  private Float price = 0F;

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Lunch getLunch() {
    return lunch;
  }

  public void setLunch(Lunch lunch) {
    this.lunch = lunch;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    if (lunch != null) {
      stringBuilder.append(lunch);
    }
    if (drink != null) {
      stringBuilder.append(drink);
    }
    stringBuilder.append(". Price: ").append(price);
    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Order order = (Order) o;

    if (!Objects.equals(lunch, order.lunch)) {
      return false;
    }
    if (!Objects.equals(drink, order.drink)) {
      return false;
    }
    return price.equals(order.price);
  }

  @Override
  public int hashCode() {
    int result = lunch != null ? lunch.hashCode() : 0;
    result = 31 * result + (drink != null ? drink.hashCode() : 0);
    result = 31 * result + price.hashCode();
    return result;
  }
}
