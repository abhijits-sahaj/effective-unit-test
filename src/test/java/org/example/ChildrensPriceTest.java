package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChildrensPriceTest {

  private final Price price = new ChildrensPrice();

  @Test
  void shouldCalculateChargeForVariousDays() {
    assertEquals(1.5, price.getCharge(0));
    assertEquals(1.5, price.getCharge(2));
    assertEquals(1.5, price.getCharge(3));
    assertEquals(3.0, price.getCharge(4));
    assertEquals(4.5, price.getCharge(5));
    assertEquals(6.0, price.getCharge(6));
    assertEquals(1.5, price.getCharge(-1));
  }

  @Test
  void shouldAlwaysReturnOnePointRegardlessOfTheNumberOfDays() {
    assertEquals(1, price.getPoints(1));
    assertEquals(1, price.getPoints(2));
    assertEquals(1, price.getPoints(3));
  }
}
