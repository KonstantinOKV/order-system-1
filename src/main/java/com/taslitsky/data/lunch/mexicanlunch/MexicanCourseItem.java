package com.taslitsky.data.lunch.mexicanlunch;

import com.taslitsky.item.CourseItem;

public enum MexicanCourseItem implements CourseItem {
  MEXICAN_FISH(20F),
  MEXICAN_CHICKEN(15.6F),
  MEXICAN_PASTA(10.8F);

  private final Float price;

  MexicanCourseItem(float price) {
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
