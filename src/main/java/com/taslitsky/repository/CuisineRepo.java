package com.taslitsky.repository;

import com.taslitsky.model.Cuisine;
import com.taslitsky.data.lunch.italianlunch.ItalianCourseItem;
import com.taslitsky.data.lunch.italianlunch.ItalianDessertItem;
import com.taslitsky.data.lunch.mexicanlunch.MexicanCourseItem;
import com.taslitsky.data.lunch.mexicanlunch.MexicanDessertItem;
import com.taslitsky.data.lunch.polishlunch.PolishCourseItem;
import com.taslitsky.data.lunch.polishlunch.PolishDessertItem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CuisineRepo {
  final private List<Cuisine> cuisines;

  public CuisineRepo() {
    cuisines = new ArrayList<>();
    cuisines.add(new Cuisine(Stream.of(ItalianCourseItem.values()).collect(Collectors.toList()), // italian courses
        Stream.of(ItalianDessertItem.values()).collect(Collectors.toList()), // italian dessert
        "Italian cuisine"));
    cuisines.add(new Cuisine(Stream.of(MexicanCourseItem.values()).collect(Collectors.toList()), // mexican courses
        Stream.of(MexicanDessertItem.values()).collect(Collectors.toList()), // mexican desserts
        "Mexican cuisine"));
    cuisines.add(new Cuisine(Stream.of(PolishCourseItem.values()).collect(Collectors.toList()), // polish courses
        Stream.of(PolishDessertItem.values()).collect(Collectors.toList()), // polish desserts
        "Polish cuisine"));
  }

  public List<Cuisine> findAll() {
    return cuisines;
  }
}
