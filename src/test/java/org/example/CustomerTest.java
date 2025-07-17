package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

  @Test
  void shouldReturnRentalStatementOfACustomerGivenTheyHaventRentedAnythingYet() {
    Customer noRentalCustomerDavid = ObjectMother.customerWithNoRentals("David");

    assertEquals("Rental record for David\n" +
            "Amount owed is 0.0\n" +
            "You earned 0 frequent renter points", noRentalCustomerDavid.statement()
    );
  }

  @Test
  void shouldReturnRentalStatementOfACustomerGivenTheyHaveRentedNewlyReleaseMovie() {
    Customer newReleaseCustomerJohn = ObjectMother.customerWithOneNewRelease("John");

    assertEquals("Rental record for John\n" +
            "\tGodfather 4 9.0\n" +
            "Amount owed is 9.0\n" +
            "You earned 2 frequent renter points", newReleaseCustomerJohn.statement());
  }

  @Test
  public void shouldReturnRentalStatementOfACustomerGivenTheyHaveRentedOneMovieOfEachType() {
    Customer eachTypeMovieCustomerPat = ObjectMother.customerWithOneOfEachRentalType("Pat");

    assertEquals(
            "Rental record for Pat\n" +
                    "\tGodfather 4 9.0\n" +
                    "\tScarface 3.5\n" +
                    "\tLion King 1.5\n" +
                    "Amount owed is 14.0\n" +
                    "You earned 4 frequent renter points",
            eachTypeMovieCustomerPat.statement());
  }

  @Test
  public void shouldReturnRentalStatementOfACustomerGivenTheyHaveRentedOneNewReleaseOneRegularMovie() {
    Customer newReleaseAndRegularCustomerSteve = ObjectMother.customerWithOneNewReleaseAndOneRegular("Steve");

    assertEquals("Rental record for Steve\n" +
                    "\tGodfather 4 9.0\n" +
                    "\tScarface 3.5\n" +
                    "Amount owed is 12.5\n" +
                    "You earned 3 frequent renter points",
            newReleaseAndRegularCustomerSteve.statement());
  }

  @Test
  public void shouldReturnHTLMLRentalStatementOfACustomerGivenTheyHaventRentedAnythingYet() {
    Customer newReleaseCustomerDavid = ObjectMother.customerWithOneNewRelease("David");

    assertEquals("<h1>Rental record for <em>David</em></h1>\n" +
            "<p>Amount owed is <em>0.0</em></p>\n" +
            "<p>You earned <em>0 frequent renter points</em></p>", newReleaseCustomerDavid.htmlStatement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaveRentedOnlyOneMovie() {
    Customer newReleaseCustomerJohn = ObjectMother.customerWithOneNewRelease("John");

    assertEquals("<h1>Rental record for <em>John</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Amount owed is <em>9.0</em></p>\n" +
                    "<p>You earned <em>2 frequent renter points</em></p>",
            newReleaseCustomerJohn.htmlStatement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaveRentedOneMovieOfEachType() {
    Customer eachTypeMovieCustomerPat = ObjectMother.customerWithOneOfEachRentalType("Pat");

    assertEquals("<h1>Rental record for <em>Pat</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Scarface 3.5</p>\n" +
                    "<p>Lion King 1.5</p>\n" +
                    "<p>Amount owed is <em>14.0</em></p>\n" +
                    "<p>You earned <em>4 frequent renter points</em></p>",
            eachTypeMovieCustomerPat.htmlStatement());
  }

  @Test
  public void shouldReturnHTMLRentalStatementOfACustomerGivenTheyHaveRentedOneNewReleaseOneRegularMovie() {
    Customer newReleaseAndRegularCustomerSteve = ObjectMother.customerWithOneNewReleaseAndOneRegular("Steve");

    assertEquals("<h1>Rental record for <em>Steve</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Scarface 3.5</p>\n" +
                    "<p>Amount owed is <em>12.5</em></p>\n" +
                    "<p>You earned <em>3 frequent renter points</em></p>",
            newReleaseAndRegularCustomerSteve.htmlStatement());
  }


  @Test
  public void invalidTitle() {
    assertThrows(IllegalArgumentException.class, () -> {
      ObjectMother.customerWithNoRentals("Bob").addRental(
              new Rental(
                      new Movie("Crazy, Stupid, Love.", Movie.Type.UNKNOWN),
                      4));
    });
  }
}