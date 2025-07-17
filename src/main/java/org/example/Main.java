package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer("Dhrupad");
    customer.addRental(new Rental(new Movie("Godfather", Movie.Type.REGULAR), 3));
    customer.addRental(new Rental(new Movie("Toy Story", Movie.Type.CHILDREN), 2));
    customer.addRental(new Rental(new Movie("Avengers", Movie.Type.NEW_RELEASE), 4));
    System.out.println(customer.statement());
  }
}