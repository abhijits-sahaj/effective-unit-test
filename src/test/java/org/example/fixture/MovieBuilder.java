package org.example.fixture;
import org.example.Movie;
import org.example.MovieType;

public class MovieBuilder {

  private String title = null;
  private MovieType movieType = null;

  public static MovieBuilder of() {
    return new MovieBuilder();
  }

  public MovieBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public MovieBuilder withType(MovieType movieType) {
    this.movieType = movieType;
    return this;
  }

  public Movie build() {
    if (title == null || movieType == null) {
      throw new IllegalStateException("Both title and type must be set to build a Movie.");
    }
    return new Movie(title, movieType);
  }
}

