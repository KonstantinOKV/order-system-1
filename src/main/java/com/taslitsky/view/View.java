package com.taslitsky.view;

import com.taslitsky.model.Menu;
import com.taslitsky.model.Cuisine;
import com.taslitsky.item.Item;
import com.taslitsky.item.PaidItem;
import com.taslitsky.model.Order;
import java.util.List;
import java.util.Scanner;

public class View {
  private Scanner scanner = new Scanner(System.in);

  public void showMenu(Menu menu) {
    System.out.println("Menu:");
    showCuisine(menu.getCuisines());
    showPaidItems(menu.getDrinks(), "Drinks");
    showItems(menu.getDrinkAddition(), "Drink additional items");
    System.out.println("\n\n");
  }

  private void showCuisine(List<Cuisine> cuisines) {
    int majorCounter = 1;
    for (Cuisine cuisine : cuisines) {
      System.out.println("=========================\n" + majorCounter + ") " + cuisine.getName());
      showPaidItems(cuisine.getCourses(), "Main courses");
      showPaidItems(cuisine.getDesserts(), "Desserts");
      System.out.println("=========================\n");
      majorCounter++;
    }
  }

  private void showPaidItems(List<? extends PaidItem> paidItems, String paidItemsDescription) {
    System.out.println(paidItemsDescription + ": ");
    int counter = 1;
    for (PaidItem paidItem :
        paidItems) {
      System.out.println(counter + ") " + paidItem.getName() + ". Price: " + paidItem.getPrice());
      counter++;
    }
  }


  private void showItems(List<? extends Item> items, String itemsDescription) {
    System.out.println(itemsDescription + ": ");
    int counter = 1;
    for (Item item :
        items) {
      System.out.println(counter + ") " + item.getName());
      counter++;
    }
  }

  public boolean askFor(String desireDescription) {
    String answer;
    do {
      System.out.print("Do you want "+ desireDescription + " ?(Y/N): ");
      answer = scanner.next();
    } while (!(answer.equals("Y") || answer.equals("N")));
    return answer.equals("Y");
  }

  public boolean wantAdditionItems() {
    String answer;
    do {
      System.out.print("Do you want some addition items to drink?(Y/N): ");
      answer = scanner.next();
    } while (!(answer.equals("Y") || answer.equals("N")));
    return answer.equals("Y");
  }

  public int selectItem(int cuisinesCount, String itemDescription) {
    int index;
    do {
      System.out.print("Select " + itemDescription + "(Enter number): ");
      index = scanner.nextInt();
    } while (index < 1 || index > cuisinesCount);
    return index;
  }

  public void printOrders(List<Order> orders) {
    System.out.println("\nOrders:");
    for (int i = 0; i < orders.size(); i++) {
      System.out.println(i + ") " + orders.get(i));
    }
  }

  public void additionItemAlreadySelected() {
    System.out.println("Your drink has already got this addition");
  }

  public void orderTaken() {
    System.out.println("Order taken successfully");
  }
}
