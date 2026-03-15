package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a band, which is a group creator.
 */
public class Band extends Creator {
  private String name;
  private List<RecordingArtist> members;

  /**
   * Constructs a band.
   *
   * @param name band name
   * @param members collection of band members
   */
  public Band(String name, List<RecordingArtist> members) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Band name cannot be null or empty.");
    }
    if (members == null) {
      throw new IllegalArgumentException("Members cannot be null.");
    }
    for (RecordingArtist member : members) {
      if (member == null) {
        throw new IllegalArgumentException("Band members cannot contain null.");
      }
    }

    this.name = name;
    this.members = new ArrayList<>(members);
  }

  public String getName() {
    return name;
  }

  public List<RecordingArtist> getMembers() {
    return new ArrayList<>(members);
  }

  /**
   * Returns whether the given artist is a member of the band.
   *
   * @param artist recording artist
   * @return true if artist is a member
   */
  public boolean hasMember(RecordingArtist artist) {
    return members.contains(artist);
  }

  @Override
  public String getDisplayName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Band)) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(name, band.name)
        && Objects.equals(members, band.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }
}
