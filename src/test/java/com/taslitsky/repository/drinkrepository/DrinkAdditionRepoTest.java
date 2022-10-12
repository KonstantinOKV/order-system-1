package com.taslitsky.repository.drinkrepository;

import com.taslitsky.data.drink.DrinkAdditionItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DrinkAdditionRepoTest {

  private DrinkAdditionRepo underTest = new DrinkAdditionRepo();

  @Test
  void findAllTest() {
    // GIVEN
    List<DrinkAdditionItem> expected = Stream.of(DrinkAdditionItem.values()).collect(
        Collectors.toList());

    // WHEN
    List<DrinkAdditionItem> actual = underTest.findAll();

    //THEN
    Assertions.assertEquals(expected, actual);
  }
}