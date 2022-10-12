package com.taslitsky.data.lunch.mexicanlunch;

import com.taslitsky.item.DessertItem;

public enum MexicanDessertItem implements DessertItem {
  MEXICAN_CAKE(5F),
  MEXICAN_ICE_CREAM(3F),
  MEXICAN_CHOCOLATE_FONDANT(4.5F);

  private final Float price;

  MexicanDessertItem(float price) {
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
