package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer("Dhrupad");
    customer.addRental(new Rental(new Movie("Godfather", MovieType.REGULAR), 3));
    customer.addRental(new Rental(new Movie("Toy Story", MovieType.CHILDREN), 2));
    customer.addRental(new Rental(new Movie("Avengers", MovieType.NEW_RELEASE), 4));
    System.out.println(customer.statement());
  }
}