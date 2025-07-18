package org.example.fixture;

import org.example.Movie;
import org.example.Rental;

public class RentalBuilder {

  private Movie movie = new Movie("Default Movie", Movie.Type.REGULAR);
  private int daysRented = 1;

  public static RentalBuilder of() {
    return new RentalBuilder();
  }

  public RentalBuilder withMovie(Movie movie) {
    this.movie = movie;
    return this;
  }

  public RentalBuilder withDaysRented(int days) {
    this.daysRented = days;
    return this;
  }

  public Rental build() {
    return new Rental(movie, daysRented);
  }
}
