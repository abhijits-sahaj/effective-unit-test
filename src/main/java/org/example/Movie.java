package org.example;

public class Movie {

  public enum Type {
    REGULAR, NEW_RELEASE, CHILDREN, UNKNOWN;
  }

  private final String title;
  Price price;

  public Movie(String title, Movie.Type movieType) {
    this.title = title;
    setPriceCode(movieType);
  }

  public String getTitle() {
    return title;
  }

  private void setPriceCode(Movie.Type movieType) {

    switch (movieType) {
      case CHILDREN:
        price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        price = new NewReleasePrice();
        break;
      case REGULAR:
        price = new RegularPrice();
        break;
      default:
        throw new IllegalArgumentException("invalid price code");
    }
  }

  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }

  public int getPoints(int daysRented) {
    return price.getPoints(daysRented);
  }
}