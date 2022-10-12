package com.taslitsky.repository.drinkrepository;

import com.taslitsky.data.drink.DrinkItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrinkRepo {
  private final List<DrinkItem> drinks;

  public DrinkRepo() {
    drinks = Stream.of(DrinkItem.values()).collect(Collectors.toList());
  }

  public List<DrinkItem> findAll() {
    return drinks;
  }
}
