package com.taslitsky.service;

import com.taslitsky.data.drink.DrinkItem;
import com.taslitsky.model.Menu;
import com.taslitsky.model.Order;
import com.taslitsky.repository.OrderRepo;
import com.taslitsky.view.View;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderSystemServiceTest {
  @Mock
  private View view;
  @Mock
  private Menu menu;
  @Mock
  private OrderRepo orderRepo;
  @InjectMocks
  private OrderSystemService underTest;
  private AutoCloseable autoCloseable;

  @BeforeEach
  void setUp() {
    autoCloseable = MockitoAnnotations.openMocks(this);
    Mockito.doReturn(Stream.of(DrinkItem.values())
        .collect(Collectors.toList()))
        .when(menu).getDrinks();
    Mockito.doReturn(1)
        .when(view).selectItem(Mockito.anyInt(), Mockito.anyString());
  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  void takeOrderTest() {
    // WHEN
    underTest.takeOrder();

    // THEN
    Mockito.verify(orderRepo).save(Mockito.any(Order.class));
    Mockito.verify(menu, Mockito.times(2)).getDrinks();
    Mockito.verify(view).selectItem(Mockito.anyInt(), Mockito.anyString());
  }
}