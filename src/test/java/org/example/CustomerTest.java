package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerTest {

  @Nested
  class Rentals {

    @Test
    void shouldAddARentalToACustomer() {
      Customer customer = new Customer("John");
      Rental mockRental = mock(Rental.class);

      customer.addRental(mockRental);

      assertTrue(customer.getRentals().contains(mockRental));
    }
  }

  @Nested
  class Charges {

    @Test
    void shouldReturnTheTotalChargesTheCustomerHasToPayGivenTheyHaveRentedAMovie() {
      Rental r1 = mock(Rental.class);
      Rental r2 = mock(Rental.class);
      when(r1.getCharge()).thenReturn(10.0);
      when(r2.getCharge()).thenReturn(5.5);

      Customer customer = new Customer("John");
      customer.addRental(r1);
      customer.addRental(r2);

      assertEquals(15.5, customer.getTotalCharge());
    }
  }

  @Nested
  class Points {

    @Test
    void shouldReturnTheTotalPointsEarnedByACustomerGivenTheyHaveRentedAMovie() {
      Rental r1 = mock(Rental.class);
      Rental r2 = mock(Rental.class);
      when(r1.getPoints()).thenReturn(1);
      when(r2.getPoints()).thenReturn(2);

      Customer customer = new Customer("John");
      customer.addRental(r1);
      customer.addRental(r2);

      assertEquals(3, customer.getTotalPoints());
    }
  }

  @Nested
  class Statements {

    @Test
    void shouldGenerateAPlainTextStatementGivenCustomerHasRentedAMovie() {
      Customer customer = new Customer("Neo");
      customer.addRental(mock(Rental.class));
      customer.addRental(mock(Rental.class));

      assertEquals("Rental record for Neo\n" +
              "\tnull\n" +
              "\tnull\n" +
              "Amount owed is 0.0\n" +
              "You earned 0 frequent renter points", customer.statement());
    }

    @Test
    void shouldGenerateAHTMLCompatibleStatementGivenCustomerHasRentedAMovie() {

      Customer customer = new Customer("Neo");
      customer.addRental(mock(Rental.class));
      customer.addRental(mock(Rental.class));

      assertEquals("<h1>Rental record for <em>Neo</em></h1>\n" +
              "<p>null</p>\n" +
              "<p>null</p>\n" +
              "<p>Amount owed is <em>0.0</em></p>\n" +
              "<p>You earned <em>0 frequent renter points</em></p>", customer.htmlStatement());
    }
  }
}
