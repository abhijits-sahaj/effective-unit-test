package org.example;

public class Movie {

  private final String title;
  MovieType movieType;

  public Movie(String title, MovieType movieType) {
    this.title = title;
    this.movieType = movieType;
  }

  public String getTitle() {
    return title;
  }

  public double getCharge(int daysRented) {
    return movieType.getCharge(daysRented);
  }

  public int getPoints(int daysRented) {
    return movieType.getPoints(daysRented);
  }
}