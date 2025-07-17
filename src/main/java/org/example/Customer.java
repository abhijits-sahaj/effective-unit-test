package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private final String name;
  private final List<Rental> rentals = new ArrayList<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Rental> getRentals() {
    return rentals;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String statement() {
    StringBuilder result = new StringBuilder("Rental record for " + getName() + "\n");

    for (Rental rental : rentals)
      result.append("\t")
              .append(rental.getLineItem())
              .append("\n");

    result.append("Amount owed is ")
            .append(getTotalCharge()).append("\n")
            .append("You earned ").append(getTotalPoints()).append(" frequent renter points");

    return result.toString();
  }

  public String htmlStatement() {
    StringBuilder result = new StringBuilder("<h1>Rental record for <em>" + getName() + "</em></h1>\n");

    for (Rental rental : rentals)
      result.append("<p>").append(rental.getLineItem()).append("</p>\n");

    result.append("<p>Amount owed is ")
            .append("<em>").append(getTotalCharge()).append("</em></p>\n")
            .append("<p>You earned <em>").append(getTotalPoints()).append(" frequent renter points</em></p>");

    return result.toString();
  }

  public double getTotalCharge() {
    double total = 0;
    for (Rental rental : rentals)
      total += rental.getCharge();
    return total;
  }

  public int getTotalPoints() {
    int total = 0;
    for (Rental rental : rentals)
      total += rental.getPoints();
    return total;
  }
}