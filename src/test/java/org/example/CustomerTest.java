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
    assertEquals(
            expStatement(
                    "Rental record for %s\n%sAmount owed is %s\nYou earned %s frequent renter points",
                    david,
                    rentalInfo("\t", "", david.getRentals())),
            david.statement()
    );
  }

  @Test
  void johnStatement() {
    assertEquals(
            expStatement(
                    "Rental record for %s\n%sAmount owed is %s\nYou earned %s frequent renter points",
                    john,
                    rentalInfo("\t", "", john.getRentals())),
            john.statement()
    );
  }

  @Test
  void patStatement() {
    assertEquals(
            expStatement(
                    "Rental record for %s\n%sAmount owed is %s\nYou earned %s frequent renter points",
                    pat,
                    rentalInfo("\t", "", pat.getRentals())),
            pat.statement()
    );
  }

  @Test
  void steveStatement() {
    assertEquals(
            expStatement(
                    "Rental record for %s\n%sAmount owed is %s\nYou earned %s frequent renter points",
                    steve,
                    rentalInfo("\t", "", steve.getRentals())),
            steve.statement()
    );
  }

  @Test
  public void davidHtmlStatement() {
    assertEquals(
            expStatement(
                    "<h1>Rental record for <em>%s</em></h1>\n%s" +
                            "<p>Amount owed is <em>%s</em></p>\n" +
                            "<p>You earned <em>%s frequent renter points</em></p>",
                    david,
                    rentalInfo("<p>", "</p>", david.getRentals())),
            david.htmlStatement());
  }

  @Test
  public void patHtmlStatement() {
    assertEquals(
            expStatement(
                    "<h1>Rental record for <em>%s</em></h1>\n%s" +
                            "<p>Amount owed is <em>%s</em></p>\n" +
                            "<p>You earned <em>%s frequent renter points</em></p>",
                    pat,
                    rentalInfo("<p>", "</p>", pat.getRentals())),
            pat.htmlStatement());
  }

  @Test
  public void steveHtmlStatement() {
    assertEquals(
            expStatement(
                    "<h1>Rental record for <em>%s</em></h1>\n%s" +
                            "<p>Amount owed is <em>%s</em></p>\n" +
                            "<p>You earned <em>%s frequent renter points</em></p>",
                    steve,
                    rentalInfo("<p>", "</p>", steve.getRentals())),
            steve.htmlStatement());
  }

  @Test
  public void johnHtmlStatement() {
    assertEquals(
            expStatement(
                    "<h1>Rental record for <em>%s</em></h1>\n%s" +
                            "<p>Amount owed is <em>%s</em></p>\n" +
                            "<p>You earned <em>%s frequent renter points</em></p>",
                    john,
                    rentalInfo("<p>", "</p>", john.getRentals())),
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

  public static String rentalInfo(String startsWith, String endsWith, List<Rental> rentals) {
    StringBuilder result = new StringBuilder();
    for (Rental rental : rentals) {
      result.append(String.format(
              "%s%s %s%s\n",
              startsWith,
              rental.getMovie().getTitle(),
              rental.getCharge(),
              endsWith));
    }
    return result.toString();
  }

  public static String expStatement(String formatStr, Customer customer, String rentalInfo) {
    return String.format(
            formatStr,
            customer.getName(),
            rentalInfo,
            customer.getTotalCharge(),
            customer.getTotalPoints());
  }
}