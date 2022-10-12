package com.taslitsky.model;

import com.taslitsky.item.CourseItem;
import com.taslitsky.item.DessertItem;
import java.util.Objects;


public class Lunch  {
  private CourseItem courseItem;
  private DessertItem dessertItem;

  private Float price = 0F;

  public CourseItem getCourseItem() {
    return courseItem;
  }

  public void setCourseItem(CourseItem courseItem) {
    this.courseItem = courseItem;
  }

  public void setDessertItem(DessertItem desertItem) {
    this.dessertItem = desertItem;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public DessertItem getDessertItem() {
    return dessertItem;
  }

  public Float getPrice() {
    return price;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(courseItem.getName()).append(", ").append(dessertItem.getName()).append(". ");
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

    Lunch lunch = (Lunch) o;

    if (!Objects.equals(courseItem, lunch.courseItem)) {
      return false;
    }
    if (!Objects.equals(dessertItem, lunch.dessertItem)) {
      return false;
    }
    return price.equals(lunch.price);
  }

  @Override
  public int hashCode() {
    int result = courseItem != null ? courseItem.hashCode() : 0;
    result = 31 * result + (dessertItem != null ? dessertItem.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }
}
