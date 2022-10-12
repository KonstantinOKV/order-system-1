package com.taslitsky.service;

import com.taslitsky.data.drink.DrinkItem;
import com.taslitsky.item.CourseItem;
import com.taslitsky.item.DessertItem;
import com.taslitsky.model.Menu;
import com.taslitsky.repository.CuisineRepo;
import com.taslitsky.repository.OrderRepo;
import com.taslitsky.repository.drinkrepository.DrinkAdditionRepo;
import com.taslitsky.repository.drinkrepository.DrinkRepo;
import com.taslitsky.builder.DrinkBuilder;
import com.taslitsky.builder.LunchBuilder;
import com.taslitsky.builder.OrderBuilder;
import com.taslitsky.model.Cuisine;
import com.taslitsky.model.Lunch;
import com.taslitsky.view.View;
import java.util.List;


public class OrderSystemService {
  private View view;
  private Menu menu;
  private OrderRepo orderRepo;

  public OrderSystemService() {
    view = new View();
    menu = new Menu();
    orderRepo = new OrderRepo();
  }

  public OrderSystemService(View view, Menu menu, OrderRepo orderRepo) {
    this.view = view;
    this.menu = menu;
    this.orderRepo = orderRepo;
  }

  private void setMenuWithAll() {
    menu.setCuisines(new CuisineRepo().findAll());
    menu.setDrinks(new DrinkRepo().findAll());
    menu.setDrinkAddition(new DrinkAdditionRepo().findAll());
  }

  public void takeOrder() {
    //set menu with all cuisines, courses, dessert, drinks and drink addition we have
    setMenuWithAll();

    view.showMenu(menu);

    OrderBuilder orderBuilder = new OrderBuilder();
    boolean wantEat = view.askFor("eat");

    if (wantEat) {
      // select course by cuisine
      int cuisineIndex = getCuisineIndex("cuisine for main course");
      int courseIndex = getCourseIndex(cuisineIndex);

      // select dessert by cuisine
      cuisineIndex = getCuisineIndex("cuisine for dessert");
      Cuisine cuisine = menu.getCuisines().get(cuisineIndex);
      int dessertIndex = getDessertIndex(cuisineIndex);

      //build lunch
      CourseItem course = cuisine.getCourses().get(courseIndex);
      DessertItem dessert = cuisine.getDesserts().get(dessertIndex);
      Lunch lunch = buildLunch(course, dessert);

      // add lunch to order
      orderBuilder = orderBuilder.lunch(lunch);
    }

    // use !wantEat first for not asking customer for a drink if he declined food
    if (!wantEat || view.askFor("drink")) {
      List<DrinkItem> drinks = menu.getDrinks();
      int drinkIndex = getDrinkIndex();

      DrinkBuilder drinkBuilder = new DrinkBuilder()
          .drink(drinks.get(drinkIndex));

      // ask user for addition items
      while (view.wantAdditionItems()) {
        int additionItemIndex = view.selectItem(menu.getDrinkAddition().size(),
            "drink addition") - 1;

        // continue if user selected already selected addition
        if (drinkBuilder.build().getAdditionItems()
            .contains(menu.getDrinkAddition().get(additionItemIndex))) {
          view.additionItemAlreadySelected();
          continue;
        }

        drinkBuilder.additionItem(menu.getDrinkAddition().get(additionItemIndex));

        // break if customer selected all addition items for drink
        if (drinkBuilder.build().getAdditionItems().equals(menu.getDrinkAddition())) {
          break;
        }
      }

      // add drink to order
     orderBuilder = orderBuilder.drink(drinkBuilder.build());
    }
    // add  order to order list
    orderRepo.save(orderBuilder.build());

    // write message that order taken successfully
    view.orderTaken();
  }

  private int getCuisineIndex(String itemDescription) {
    return view.selectItem(menu.getCuisines().size(), itemDescription) - 1;
  }

  private int getCourseIndex(int selectedItemId) {
    return view.selectItem(menu.getCuisines()
        .get(selectedItemId).getCourses().size(), "course") - 1;
  }

  private int getDessertIndex(int selectedItemId) {
    return view.selectItem(menu.getCuisines()
        .get(selectedItemId).getDesserts().size(), "dessert") - 1;
  }

  private int getDrinkIndex() {
    return view.selectItem(menu.getDrinks().size(), "drink") - 1;
  }

  private Lunch buildLunch(CourseItem course, DessertItem dessert) {
    return new LunchBuilder()
        .course(course)
        .dessert(dessert)
        .build();
  }

  public View getView() {
    return view;
  }

  public OrderRepo getOrderRepo() {
    return orderRepo;
  }

}
