package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularPriceTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2})
  void shouldReturnBasePriceWhenRentedForUpToTwoDays(int daysRented) {
    RegularPrice regularPrice = new RegularPrice();

    assertEquals(2.0, regularPrice.getCharge(daysRented));
  }

  @Test
  void shouldAddExtraChargeOfOnePointFiveWhenRentedForMoreThanTwoDays() {
    RegularPrice regularPrice = new RegularPrice();

    assertEquals(3.5, regularPrice.getCharge(3));
  }

  @Test
  void shouldReturnBasePriceWhenRentedForZeroDays() {
    RegularPrice regularPrice = new RegularPrice();

    assertEquals(2.0, regularPrice.getCharge(0));
  }

  @Test
  void shouldReturnBasePriceWhenRentedForNegativeDays() {
    RegularPrice regularPrice = new RegularPrice();

    assertEquals(2.0, regularPrice.getCharge(-5));
  }

  @ParameterizedTest
  @ValueSource(ints = {-5, 0, 1, 2, 3, 10, 100})
  void shouldAlwaysReturnOnePointRegardlessOfDaysRented(int daysRented) {
    RegularPrice regularPrice = new RegularPrice();

    assertEquals(1, regularPrice.getPoints(daysRented));
  }
}
