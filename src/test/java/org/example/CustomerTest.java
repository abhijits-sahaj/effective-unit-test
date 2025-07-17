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
  public void statement() {
    for (Customer customer : customers) {
      assertEquals(
              expStatement(
                      "Rental record for %s\n%sAmount owed is %s\nYou earned %s frequent renter points",
                      customer,
                      rentalInfo("\t", "", customer.getRentals())),
              customer.statement()
      );
    }
  }

  @Test
  public void htmlStatement() {
    for (Customer customer : customers) {
      assertEquals(
              expStatement(
                      "<h1>Rental record for <em>%s</em></h1>\n%s" +
                              "<p>Amount owed is <em>%s</em></p>\n" +
                              "<p>You earned <em>%s frequent renter points</em></p>",
                      customer,
                      rentalInfo("<p>", "</p>", customer.getRentals())),
              customer.htmlStatement()
      );
    }
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
              "%s%s\t%s%s\n",
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