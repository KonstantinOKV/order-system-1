package com.taslitsky;


import com.taslitsky.service.OrderSystemService;

public class OrderSystemApp {
  public static void main(String[] args) {
    OrderSystemApp app = new OrderSystemApp();
    app.start();
  }

  public void start() {
    OrderSystemService orderSystemService = new OrderSystemService();
    do {
      orderSystemService.takeOrder();
    } while (!orderSystemService.getView().askFor("stop taking orders"));

    orderSystemService.getView().printOrders(orderSystemService.getOrderRepo().findAll());
  }
}
