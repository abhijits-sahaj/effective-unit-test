package org.example;

public class ChildrensPrice extends Price {

  @Override
  double getCharge(int daysRented) {

    double basePrice = 1.5;
    if (daysRented > 3)
      basePrice += (daysRented - 3) * 1.5;

    return basePrice;
  }
}
