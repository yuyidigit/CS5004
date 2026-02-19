package Problem1;


import java.util.Arrays;

public abstract class AbstractExhibitingArtist extends AbstractArtist {
  private final String[] exhibits;

  protected AbstractExhibitingArtist(Name name, int age, String[] genres, String[] awards, String[] exhibits) {
    super(name, age, genres, awards);
    this.exhibits = exhibits == null ? new String[0] : Arrays.copyOf(exhibits, exhibits.length);
  }

  public String[] getExhibits() { return Arrays.copyOf(exhibits, exhibits.length); }
}

