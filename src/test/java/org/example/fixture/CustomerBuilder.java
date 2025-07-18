package org.example.fixture;

import org.example.Customer;
import org.example.Movie;
import org.example.Rental;

import java.util.ArrayList;
import java.util.List;

public class CustomerBuilder {

  private String name = "Default Customer";
  private final List<Rental> rentals = new ArrayList<>();

  public static CustomerBuilder of() {
    return new CustomerBuilder();
  }

  public CustomerBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CustomerBuilder withRental(Movie movie, int daysRented) {
    this.rentals.add(new Rental(movie, daysRented));
    return this;
  }

  public CustomerBuilder withRental(Rental rental) {
    this.rentals.add(rental);
    return this;
  }

  public CustomerBuilder withRentals(List<Rental> rentals) {
    this.rentals.addAll(rentals);
    return this;
  }

  public Customer build() {
    Customer customer = new Customer(name);
    for (Rental rental : rentals) {
      customer.addRental(rental);
    }
    return customer;
  }
}

