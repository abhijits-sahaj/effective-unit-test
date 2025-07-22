package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewReleasePriceTest {

  private final Price price = new NewReleasePrice();

  @Test
  void shouldCalculateChargeForVariousDays() {
    assertEquals(0.0, price.getCharge(0));
    assertEquals(3.0, price.getCharge(1));
    assertEquals(6.0, price.getCharge(2));
    assertEquals(15.0, price.getCharge(5));
    assertEquals(-3.0, price.getCharge(-1));
    assertEquals(1, price.getPoints(-1));
  }

  @Test
  void shouldCalculatePointsForVariousDays() {
    assertEquals(1, price.getPoints(0));
    assertEquals(1, price.getPoints(1));
    assertEquals(2, price.getPoints(2));
    assertEquals(2, price.getPoints(10));
  }
}
