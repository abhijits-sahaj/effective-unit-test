package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChildrensPriceTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void shouldReturnBasePriceWhenRentedForUpToThreeDays(int daysRented) {
    ChildrensPrice childrensPrice = new ChildrensPrice();

    assertEquals(1.5, childrensPrice.getCharge(daysRented));
  }

  @Test
  void shouldAddExtraChargeOfOnePointFiveWhenRentedForFourDays() {
    ChildrensPrice childrensPrice = new ChildrensPrice();

    assertEquals(3.0, childrensPrice.getCharge(4));
  }

  @Test
  void shouldAddExtraChargeInMultipleOfOnePointFiveWhenRentedForMoreThan3Days() {
    ChildrensPrice childrensPrice = new ChildrensPrice();

    assertEquals(4.5, childrensPrice.getCharge(5));
  }

  @Test
  void shouldReturnBasePriceWhenRentedForZeroDays() {
    ChildrensPrice childrensPrice = new ChildrensPrice();

    assertEquals(1.5, childrensPrice.getCharge(0));
  }

  @Test
  void shouldReturnBasePriceWhenRentedForNegativeDays() {
    ChildrensPrice childrensPrice = new ChildrensPrice();

    assertEquals(1.5, childrensPrice.getCharge(-2));
  }

  @ParameterizedTest
  @ValueSource(ints = {-5, 0, 1, 2, 3, 10, 100})
  void shouldAlwaysReturnOnePointRegardlessOfDaysRented(int daysRented) {
    RegularPrice regularPrice = new RegularPrice();

    assertEquals(1, regularPrice.getPoints(daysRented));
  }
}
