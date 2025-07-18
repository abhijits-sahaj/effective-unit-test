package org.example.fixture;
import org.example.Movie;

public class MovieBuilder {

  private String title = null;
  private Movie.Type type = null;

  public static MovieBuilder of() {
    return new MovieBuilder();
  }

  public MovieBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public MovieBuilder withType(Movie.Type type) {
    this.type = type;
    return this;
  }

  public Movie build() {
    if (title == null || type == null) {
      throw new IllegalStateException("Both title and type must be set to build a Movie.");
    }
    return new Movie(title, type);
  }
}

