package com.taslitsky.repository.drinkrepository;

import com.taslitsky.data.drink.DrinkItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DrinkRepoTest {
  private DrinkRepo underTest = new DrinkRepo();

  @Test
  void findAll() {
    // GIVEN
    List<DrinkItem> expected = Stream.of(DrinkItem.values()).collect(
        Collectors.toList());

    // WHEN
    List<DrinkItem> actual = underTest.findAll();

    //THEN
    Assertions.assertEquals(expected, actual);
  }
}