package com.taslitsky.model;


import com.taslitsky.data.drink.DrinkAdditionItem;
import com.taslitsky.data.drink.DrinkItem;
import com.taslitsky.item.Item;
import java.util.ArrayList;
import java.util.List;

public class Drink {
  private DrinkItem drinkItem;
  private final List<DrinkAdditionItem> additionItems = new ArrayList<>();

  public DrinkItem getDrinkItem() {
    return drinkItem;
  }

  public List<DrinkAdditionItem> getAdditionItems() {
    return additionItems;
  }

  public void setDrinkItem(DrinkItem drinkItem) {
    this.drinkItem = drinkItem;
  }

  @Override
  public String toString() {
    StringBuilder drinkStringBuilder  =  new StringBuilder(drinkItem.getName());

    if(!additionItems.isEmpty()) {
      drinkStringBuilder.append(" with ");
      for (Item additionItem:
      additionItems) {
        drinkStringBuilder.append(additionItem.getName()).append(", ");
      }
      drinkStringBuilder.setLength(drinkStringBuilder.length()-2);
    }
    return drinkStringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Drink drink = (Drink) o;

    if (drinkItem != drink.drinkItem) {
      return false;
    }
    return additionItems.equals(drink.additionItems);
  }

  @Override
  public int hashCode() {
    int result = drinkItem != null ? drinkItem.hashCode() : 0;
    result = 31 * result + additionItems.hashCode();
    return result;
  }
}
