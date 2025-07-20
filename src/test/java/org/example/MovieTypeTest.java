package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTypeTest {

  @Nested
  class Regular {

    @Nested
    class Charges {
      @Test
      void shouldReturnChargesGivenARegularMovieIsRented() {
        assertEquals(2.0, MovieType.REGULAR.getCharge(2));
      }
    }

    @Nested
    class Points {
      @Test
      void shouldReturnPointsGivenARegularMovieIsRented() {
        assertEquals(1, MovieType.REGULAR.getPoints(2));
      }
    }
  }

  @Nested
  class NewRelease {

    @Nested
    class Charges {
      @Test
      void shouldReturnChargesGivenANewReleaseMovieIsRented() {
        assertEquals(6.0, MovieType.NEW_RELEASE.getCharge(2));
      }
    }

    @Nested
    class Points {
      @Test
      void shouldReturnPointsGivenANewReleaseMovieIsRented() {
        assertEquals(2, MovieType.NEW_RELEASE.getPoints(2));
      }
    }
  }

  @Nested
  class Children {

    @Nested
    class Charges {
      @Test
      void shouldReturnChargesGivenAChildrenMovieIsRented() {
        assertEquals(1.5, MovieType.CHILDREN.getCharge(3));
      }
    }

    @Nested
    class Points {
      @Test
      void shouldReturnPointsGivenAChildrenMovieIsRented() {
        assertEquals(1, MovieType.CHILDREN.getPoints(3));
      }
    }
  }

  @Nested
  class Unknown {

    @Nested
    class Charges {
      @Test
      void shouldThrowExceptionGivenAnUnknownMovieTypeWhenGettingCharge() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> MovieType.UNKNOWN.getCharge(1));
        assertEquals("invalid price code", exception.getMessage());
      }
    }

    @Nested
    class Points {
      @Test
      void shouldThrowExceptionGivenAnUnknownMovieTypeWhenGettingPoints() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> MovieType.UNKNOWN.getPoints(1));
        assertEquals("invalid price code", exception.getMessage());
      }
    }
  }
}