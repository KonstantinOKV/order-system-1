package com.taslitsky.builder;

import com.taslitsky.item.CourseItem;
import com.taslitsky.item.DessertItem;
import com.taslitsky.model.Lunch;

public class LunchBuilder implements Builder {
  private final Lunch lunch = new Lunch();

  /**
   * @param courseItem model.
   * @return LunchBuilder instance.
   */
  public LunchBuilder course(CourseItem courseItem) {
    lunch.setCourseItem(courseItem);
    lunch.setPrice(lunch.getPrice() + courseItem.getPrice());
    return this;
  }

  /**
   * @param dessertItem model.
   * @return LunchBuilder instance.
   */
  public LunchBuilder dessert(DessertItem dessertItem) {
    lunch.setDessertItem(dessertItem);
    lunch.setPrice(lunch.getPrice() + dessertItem.getPrice());
    return this;
  }

  /**
   * @return build lunch.
   */
  public Lunch build() {
    return lunch;
  }
}
