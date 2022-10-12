package com.taslitsky.data.lunch.italianlunch;

import com.taslitsky.item.DessertItem;

public enum ItalianDessertItem implements DessertItem {
  ITALIAN_CAKE(5F),
  ITALIAN_ICE_CREAM(3F),
  ITALIAN_CHOCOLATE_FONDANT(4.5F);
  private final Float price;

  ItalianDessertItem(float price) {
    this.price = price;
  }

  @Override
  public String getName() {
    StringBuilder name = new StringBuilder(this.name().toLowerCase());
    name.setCharAt(0, Character.toUpperCase(name.charAt(0)));
    for (int i = 0; i < name.length(); i++) {
      if(name.charAt(i) == '_') {
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
