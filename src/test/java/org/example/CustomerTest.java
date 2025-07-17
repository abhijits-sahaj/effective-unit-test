package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

  Customer john, steve, pat, david;
  String johnName = "John",
          steveName = "Steve",
          patName = "Pat",
          davidName = "David";
  Customer[] customers;

  @BeforeEach
  public void setup() {
    david = ObjectMother.customerWithNoRentals(davidName);
    john = ObjectMother.customerWithOneNewRelease(johnName);
    pat = ObjectMother.customerWithOneOfEachRentalType(patName);
    steve = ObjectMother.customerWithOneNewReleaseAndOneRegular(steveName);
    customers = new Customer[]{david, john, steve, pat};
  }

  @Test
  public void getName() {
    assertEquals(davidName, david.getName());
    assertEquals(johnName, john.getName());
    assertEquals(steveName, steve.getName());
    assertEquals(patName, pat.getName());
  }

  @Test
  void davidStatement() {
    assertEquals("Rental record for David\n" +
            "Amount owed is 0.0\n" +
            "You earned 0 frequent renter points", david.statement()
    );
  }

  @Test
  public void johnStatement() {
    assertEquals("Rental record for John\n" +
                    "\tGodfather 4 9.0\n" +
                    "Amount owed is 9.0\n" +
                    "You earned 2 frequent renter points",
            john.statement());
  }

  @Test
  public void patStatement() {
    assertEquals(
            "Rental record for Pat\n" +
                    "\tGodfather 4 9.0\n" +
                    "\tScarface 3.5\n" +
                    "\tLion King 1.5\n" +
                    "Amount owed is 14.0\n" +
                    "You earned 4 frequent renter points",
            pat.statement());
  }

  @Test
  public void steveStatement() {
    assertEquals("Rental record for Steve\n" +
                    "\tGodfather 4 9.0\n" +
                    "\tScarface 3.5\n" +
                    "Amount owed is 12.5\n" +
                    "You earned 3 frequent renter points",
            steve.statement());
  }

  @Test
  public void davidHtmlStatement() {
    assertEquals("<h1>Rental record for <em>David</em></h1>\n" +
            "<p>Amount owed is <em>0.0</em></p>\n" +
            "<p>You earned <em>0 frequent renter points</em></p>", david.htmlStatement());
  }

  @Test
  public void patHtmlStatement() {
    assertEquals("<h1>Rental record for <em>Pat</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Scarface 3.5</p>\n" +
                    "<p>Lion King 1.5</p>\n" +
                    "<p>Amount owed is <em>14.0</em></p>\n" +
                    "<p>You earned <em>4 frequent renter points</em></p>",
            pat.htmlStatement());
  }

  @Test
  public void steveHtmlStatement() {
    assertEquals("<h1>Rental record for <em>Steve</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Scarface 3.5</p>\n" +
                    "<p>Amount owed is <em>12.5</em></p>\n" +
                    "<p>You earned <em>3 frequent renter points</em></p>",
            steve.htmlStatement());
  }

  @Test
  public void johnHtmlStatement() {
    assertEquals("<h1>Rental record for <em>John</em></h1>\n" +
                    "<p>Godfather 4 9.0</p>\n" +
                    "<p>Amount owed is <em>9.0</em></p>\n" +
                    "<p>You earned <em>2 frequent renter points</em></p>",
            john.htmlStatement());
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