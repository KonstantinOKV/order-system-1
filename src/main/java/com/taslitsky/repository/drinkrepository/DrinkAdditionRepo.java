package com.taslitsky.repository.drinkrepository;

import com.taslitsky.data.drink.DrinkAdditionItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrinkAdditionRepo {
  private final List<DrinkAdditionItem> drinkAdditionItems;

  public DrinkAdditionRepo() {
    drinkAdditionItems = Stream.of(DrinkAdditionItem.values()).collect(Collectors.toList());
  }

  public List<DrinkAdditionItem> findAll() {
    return drinkAdditionItems;
  }
}
