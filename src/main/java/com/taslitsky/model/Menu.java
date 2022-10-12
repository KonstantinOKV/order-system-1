package com.taslitsky.model;

import com.taslitsky.data.drink.DrinkAdditionItem;
import com.taslitsky.data.drink.DrinkItem;
import java.util.ArrayList;
import java.util.List;


public class Menu  {
  private List<Cuisine> cuisines;
  private List<DrinkItem> drinks;
  private List<DrinkAdditionItem> drinkAddition;

  public Menu() {
    cuisines = new ArrayList<>();
    drinks = new ArrayList<>();
    drinkAddition = new ArrayList<>();
  }

  public List<Cuisine> getCuisines() {
    return cuisines;
  }

  public void setCuisines(List<Cuisine> cuisines) {
    this.cuisines = cuisines;
  }

  public void setDrinks(List<DrinkItem> drinks) {
    this.drinks = drinks;
  }

  public void setDrinkAddition(
      List<DrinkAdditionItem> drinkAdditionItems) {
      drinkAddition = drinkAdditionItems;
  }

  public List<DrinkItem> getDrinks() {
    return drinks;
  }

  public List<DrinkAdditionItem> getDrinkAddition() {
    return drinkAddition;
  }


}