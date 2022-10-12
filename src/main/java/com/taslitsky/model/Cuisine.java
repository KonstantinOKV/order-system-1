package com.taslitsky.model;

import com.taslitsky.item.CourseItem;
import com.taslitsky.item.DessertItem;
import com.taslitsky.item.Item;
import java.util.List;
import java.util.Objects;

public class Cuisine implements Item {
  private List<CourseItem> courses;
  private List<DessertItem> desserts;

  private final String name;

  public Cuisine(List<CourseItem> courses, List<DessertItem> desserts, String name) {
    this.courses = courses;
    this.desserts = desserts;
    this.name = name;
  }

  public List<CourseItem> getCourses() {
    return courses;
  }

  public List<DessertItem> getDesserts() {
    return desserts;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Cuisine cuisine = (Cuisine) o;

    if (!Objects.equals(courses, cuisine.courses)) {
      return false;
    }
    if (!Objects.equals(desserts, cuisine.desserts)) {
      return false;
    }
    return Objects.equals(name, cuisine.name);
  }

  @Override
  public int hashCode() {
    int result = courses != null ? courses.hashCode() : 0;
    result = 31 * result + (desserts != null ? desserts.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
