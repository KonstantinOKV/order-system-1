package com.taslitsky.data.drink;

import com.taslitsky.item.Item;

public enum DrinkAdditionItem implements Item {
  LEMON,
  ICE_CUBES;


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


}
