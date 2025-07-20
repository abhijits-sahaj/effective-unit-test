package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewReleasePriceTest {

  @ParameterizedTest
  @CsvSource({
          "0, 0.0",
          "1, 3.0",
          "2, 6.0",
          "3, 9.0",
          "4, 12.0"
  })
  void shouldReturnChargeAsThreeTimesDaysRented(int daysRented, double expectedCharge) {
    NewReleasePrice newReleasePrice = new NewReleasePrice();

    assertEquals(expectedCharge, newReleasePrice.getCharge(daysRented));
  }

  @ParameterizedTest
  @ValueSource(ints = {-3, 0, 1})
  void shouldReturnOnePointGivenItsRentedForOneOrFewerDays(int daysRented) {
    NewReleasePrice newReleasePrice = new NewReleasePrice();

    assertEquals(1, newReleasePrice.getPoints(daysRented));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 3, 10})
  void shouldReturnTwoPointsGivenItsRentedForMoreThanOneDay(int daysRented) {
    NewReleasePrice newReleasePrice = new NewReleasePrice();

    assertEquals(2, newReleasePrice.getPoints(daysRented));
  }
}
