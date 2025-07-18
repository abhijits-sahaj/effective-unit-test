package org.example;

import org.example.fixture.CustomerBuilder;
import org.example.fixture.MovieBuilder;
import org.example.fixture.RentalBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

  @Test
  void shouldReturnRentalStatementOfACustomerGivenTheyHaventRentedAnythingYet() {
    Customer customer = CustomerBuilder.of()
            .withName("David")
            .build();

    assertEquals("Rental record for David\n" +
                    "Amount owed is 0.0\n" +
                    "You earned 0 frequent renter points",
            customer.statement());
  }

  @Test
  void shouldReturnRentalStatementOfACustomerGivenTheyHaveRentedANewlyReleaseMovieFor3Days() {
    Movie godfather4 = MovieBuilder.of()
            .withTitle("Godfather 4")
            .withType(Movie.Type.NEW_RELEASE)
            .build();

    Customer customer = CustomerBuilder.of()
            .withName("John")
            .withRental(RentalBuilder.of()
                    .withMovie(godfather4)
                    .withDaysRented(3)
                    .build())
            .build();

    assertEquals("Rental record for John\n" +
                    "\tGodfather 4 9.0\n" +
                    "Amount owed is 9.0\n" +
                    "You earned 2 frequent renter points",
            customer.statement());
  }

  @Test
  public void shouldReturnRentalStatementOfACustomerGivenTheyHaveRentedOneMovieOfEachTypeFor3Days() {
    Movie godfather4 = MovieBuilder.of().withTitle("Godfather 4").withType(Movie.Type.NEW_RELEASE).build();
    Movie scarface = MovieBuilder.of().withTitle("Scarface").withType(Movie.Type.REGULAR).build();
    Movie lionKing = MovieBuilder.of().withTitle("Lion King").withType(Movie.Type.CHILDREN).build();

    Customer customer = CustomerBuilder.of()
            .withName("Pat")
            .withRental(RentalBuilder.of().withMovie(godfather4).withDaysRented(3).build())
            .withRental(RentalBuilder.of().withMovie(scarface).withDaysRented(3).build())
            .withRental(RentalBuilder.of().withMovie(lionKing).withDaysRented(3).build())
            .build();

    assertEquals("Rental record for Pat\n" +
                    "\tGodfather 4 9.0\n" +
                    "\tScarface 3.5\n" +
                    "\tLion King 1.5\n" +
                    "Amount owed is 14.0\n" +
                    "You earned 4 frequent renter points",
            customer.statement());
  }

  @Test
  public void shouldReturnRentalStatementOfACustomerGivenTheyHaveRentedOneNewReleaseOneRegularMovieFor3Days() {
    Movie godfather4 = MovieBuilder.of().withTitle("Godfather 4").withType(Movie.Type.NEW_RELEASE).build();
    Movie scarface = MovieBuilder.of().withTitle("Scarface").withType(Movie.Type.REGULAR).build();

    Customer customer = CustomerBuilder.of()
            .withName("Steve")
            .withRental(RentalBuilder.of().withMovie(godfather4).withDaysRented(3).build())
            .withRental(RentalBuilder.of().withMovie(scarface).withDaysRented(3).build())
            .build();

    assertEquals("Rental record for Steve\n" +
                    "\tGodfather 4 9.0\n" +
                    "\tScarface 3.5\n" +
                    "Amount owed is 12.5\n" +
                    "You earned 3 frequent renter points",
            customer.statement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaventRentedAnythingYet() {
    Customer customer = CustomerBuilder.of()
            .withName("David")
            .build();

    assertEquals("<h1>Rental record for <em>David</em></h1>\n" +
                    "<p>Amount owed is <em>0.0</em></p>\n" +
                    "<p>You earned <em>0 frequent renter points</em></p>",
            customer.htmlStatement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaveRentedOnlyOneMovieFor3Days() {
    Movie godfather4 = MovieBuilder.of()
            .withTitle("Godfather 4")
            .withType(Movie.Type.NEW_RELEASE)
            .build();

    Customer customer = CustomerBuilder.of()
            .withName("John")
            .withRental(RentalBuilder.of().withMovie(godfather4).withDaysRented(3).build())
            .build();

    assertEquals("<h1>Rental record for <em>John</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Amount owed is <em>9.0</em></p>\n" +
                    "<p>You earned <em>2 frequent renter points</em></p>",
            customer.htmlStatement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaveRentedOneMovieOfEachTypeFor3Days() {
    Movie godfather4 = MovieBuilder.of().withTitle("Godfather 4").withType(Movie.Type.NEW_RELEASE).build();
    Movie scarface = MovieBuilder.of().withTitle("Scarface").withType(Movie.Type.REGULAR).build();
    Movie lionKing = MovieBuilder.of().withTitle("Lion King").withType(Movie.Type.CHILDREN).build();

    Customer customer = CustomerBuilder.of()
            .withName("Pat")
            .withRental(RentalBuilder.of().withMovie(godfather4).withDaysRented(3).build())
            .withRental(RentalBuilder.of().withMovie(scarface).withDaysRented(3).build())
            .withRental(RentalBuilder.of().withMovie(lionKing).withDaysRented(3).build())
            .build();

    assertEquals("<h1>Rental record for <em>Pat</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Scarface 3.5</p>\n" +
                    "<p>Lion King 1.5</p>\n" +
                    "<p>Amount owed is <em>14.0</em></p>\n" +
                    "<p>You earned <em>4 frequent renter points</em></p>",
            customer.htmlStatement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaveRentedOneNewReleaseOneRegularMovieFor3Days() {
    Movie godfather4 = MovieBuilder.of().withTitle("Godfather 4").withType(Movie.Type.NEW_RELEASE).build();
    Movie scarface = MovieBuilder.of().withTitle("Scarface").withType(Movie.Type.REGULAR).build();

    Customer customer = CustomerBuilder.of()
            .withName("Steve")
            .withRental(RentalBuilder.of().withMovie(godfather4).withDaysRented(3).build())
            .withRental(RentalBuilder.of().withMovie(scarface).withDaysRented(3).build())
            .build();

    assertEquals("<h1>Rental record for <em>Steve</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Scarface 3.5</p>\n" +
                    "<p>Amount owed is <em>12.5</em></p>\n" +
                    "<p>You earned <em>3 frequent renter points</em></p>",
            customer.htmlStatement());
  }
}
