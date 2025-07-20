package org.example;

public enum MovieType {

  REGULAR(new RegularPrice()),
  NEW_RELEASE(new NewReleasePrice()),
  CHILDREN(new ChildrensPrice()),
  UNKNOWN(null); // We’ll handle this with validation

  private final Price price;

  MovieType(Price strategy) {
    this.price = strategy;
  }

  public double getCharge(int daysRented) {
    if (price == null)
      throw new IllegalArgumentException("invalid price code");

    return price.getCharge(daysRented);
  }

  public int getPoints(int daysRented) {
    if (price == null)
      throw new IllegalArgumentException("invalid price code");

    return price.getPoints(daysRented);
  }
}

