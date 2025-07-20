package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MovieTest {

  @Test
  void shouldReturnTheChargeOfTheMovieGivenTheNumberOfDaysToBeRented() {
    MovieType mockType = mock(MovieType.class);
    when(mockType.getCharge(3)).thenReturn(7.5);

    Movie movie = new Movie("Inception", mockType);
    double charge = movie.getCharge(3);

    assertEquals(7.5, charge);
    verify(mockType).getCharge(3);
  }

  @Test
  void shouldReturnTheLoyaltyPointsToBeEarnedGivenTheNumberOfDaysToBeRented() {
    MovieType mockType = mock(MovieType.class);
    when(mockType.getPoints(5)).thenReturn(2);

    Movie movie = new Movie("Interstellar", mockType);
    int points = movie.getPoints(5);

    assertEquals(2, points);
    verify(mockType).getPoints(5);
  }

  @Test
  void shouldReturnTheTitleOfTheMovie() {
    MovieType mockType = mock(MovieType.class);

    Movie movie = new Movie("The Matrix", mockType);

    assertEquals("The Matrix", movie.getTitle());
  }
}
