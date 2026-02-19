package Problem1;


import java.util.Arrays;

public abstract class AbstractMultimediaArtist extends AbstractArtist {
  private final String[] movies;
  private final String[] series;
  private final String[] otherMultimedia;

  protected AbstractMultimediaArtist(Name name, int age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] otherMultimedia) {
    super(name, age, genres, awards);
    this.movies = movies == null ? new String[0] : Arrays.copyOf(movies, movies.length);
    this.series = series == null ? new String[0] : Arrays.copyOf(series, series.length);
    this.otherMultimedia = otherMultimedia == null ? new String[0] : Arrays.copyOf(otherMultimedia, otherMultimedia.length);
  }

  public String[] getMovies() { return Arrays.copyOf(movies, movies.length); }
  public String[] getSeries() { return Arrays.copyOf(series, series.length); }
  public String[] getOtherMultimedia() { return Arrays.copyOf(otherMultimedia, otherMultimedia.length); }
}

