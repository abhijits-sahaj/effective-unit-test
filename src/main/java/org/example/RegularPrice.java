package org.example;

public class RegularPrice extends Price {

  @Override
  public double getCharge(int daysRented) {

    double basePrice = 2;
    if (daysRented > 2)
      basePrice += (daysRented - 2) * 1.5;

    return basePrice;
  }
}
