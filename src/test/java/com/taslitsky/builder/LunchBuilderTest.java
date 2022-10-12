package com.taslitsky.builder;


import com.taslitsky.model.Lunch;
import com.taslitsky.data.lunch.italianlunch.ItalianCourseItem;
import com.taslitsky.data.lunch.italianlunch.ItalianDessertItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LunchBuilderTest {
  private LunchBuilder underTest = new LunchBuilder();

  @Test
  void LunchNotNullTest() {
    Assertions.assertNotNull(underTest.build());
  }

  @Test
  void courseTest() {
    // GIVEN
    Lunch expected = new Lunch();
    expected.setCourseItem(ItalianCourseItem.ITALIAN_CHICKEN);
    expected.setPrice(15.6F);

    // WHEN
    Lunch actual = underTest
        .course(ItalianCourseItem.ITALIAN_CHICKEN)
        .build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void dessertTest() {
    // GIVEN
    Lunch expected = new Lunch();
    expected.setDessertItem(ItalianDessertItem.ITALIAN_CAKE);
    expected.setPrice(5F);

    // WHEN
    Lunch actual = underTest
        .dessert(ItalianDessertItem.ITALIAN_CAKE)
        .build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void buildTest() {
    // GIVEN
    Lunch expected = new Lunch();

    // WHEN
    Lunch actual = underTest.build();

    // THEN
    Assertions.assertEquals(expected, actual);
  }
}