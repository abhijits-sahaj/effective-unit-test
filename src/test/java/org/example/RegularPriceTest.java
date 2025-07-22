package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularPriceTest {

  private final Price price = new RegularPrice();

  @Test
  void shouldCalculateChargeForVariousDurations() {
    assertEquals(2.0, price.getCharge(0));
    assertEquals(2.0, price.getCharge(1));
    assertEquals(2.0, price.getCharge(2));
    assertEquals(3.5, price.getCharge(3));
    assertEquals(5.0, price.getCharge(4));
    assertEquals(6.5, price.getCharge(5));
    assertEquals(2.0, price.getCharge(-2));
  }

  @Test
  void shouldAlwaysReturnOnePointRegardlessOfTheNumberOfDays() {
    assertEquals(1, price.getPoints(1));
    assertEquals(1, price.getPoints(2));
    assertEquals(1, price.getPoints(3));
  }
}
