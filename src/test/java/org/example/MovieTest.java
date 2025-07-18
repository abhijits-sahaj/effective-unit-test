package org.example;

import org.example.fixture.MovieBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieTest {

  @Test
  public void shouldRaiseAnInvalidTitleErrorGivenAMovieCreatedWithUnknownType() {
    assertThrows(IllegalArgumentException.class, () -> {
      MovieBuilder.of()
              .withTitle("Crazy, Stupid, Love.")
              .withType(Movie.Type.UNKNOWN)
              .build();
    });
  }
}