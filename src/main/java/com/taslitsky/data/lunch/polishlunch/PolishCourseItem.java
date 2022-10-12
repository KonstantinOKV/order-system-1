package com.taslitsky.data.lunch.polishlunch;

import com.taslitsky.item.CourseItem;

public enum PolishCourseItem implements CourseItem {
  POLISH_FISH(20F),
  POLISH_CHICKEN(15.6F),
  POLISH_PASTA(10.8F);

  private final Float price;

  PolishCourseItem(float price) {
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
