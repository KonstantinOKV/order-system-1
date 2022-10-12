package com.taslitsky.data.drink;

import com.taslitsky.item.PaidItem;

public enum DrinkItem implements PaidItem {

  PEPSI(1.5F),
  COCA_COLA(1.8F),
  WATER(1F),
  BEER(2.4F),
  FANTA(1.7F),
  SPRITE(2F);

  private final Float price; // not float but Float for future DB impl

  DrinkItem(float price) {
    this.price = price;
  }

  @Override
  public String getName() {
    StringBuilder name = new StringBuilder(this.name().toLowerCase());
    name.setCharAt(0, Character.toUpperCase(name.charAt(0)));
    for (int i = 0; i < name.length(); i++) {
      if (name.charAt(i) == '_') {
        name.setCharAt(i, ' ');
      }
    }
    return name.toString();
  }

  @Override
  public Float getPrice() {
    return price;
  }
}
