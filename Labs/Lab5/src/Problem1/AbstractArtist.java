package Problem1;


import java.util.Arrays;

public abstract class AbstractArtist implements Artist {
  private final Name name;
  private final int age;
  private final String[] genres;
  private String[] awards;

  protected AbstractArtist(Name name, int age, String[] genres, String[] awards) {
    if (name == null) throw new IllegalArgumentException("name null");
    if (age < 0 || age > 128) throw new IllegalArgumentException("age out of range [0,128]");
    this.name = name;
    this.age = age;
    this.genres = (genres == null) ? new String[0] : Arrays.copyOf(genres, genres.length);
    this.awards = (awards == null) ? new String[0] : Arrays.copyOf(awards, awards.length);
  }

  @Override
  public void receiveAward(String award) {
    if (award == null) throw new IllegalArgumentException("award null");
    String[] bigger = Arrays.copyOf(awards, awards.length + 1);
    bigger[awards.length] = award;
    awards = bigger;
  }

  @Override public Name getName() { return name; }
  @Override public int getAge() { return age; }
  @Override public String[] getGenres() { return Arrays.copyOf(genres, genres.length); }
  @Override public String[] getAwards() { return Arrays.copyOf(awards, awards.length); }
}

