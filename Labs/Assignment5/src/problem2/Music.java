package problem2;

/**
 * Represents a music item.
 */
public class Music extends Item {

  /**
   * Constructs a music item with a recording artist as creator.
   *
   * @param artist recording artist
   * @param title title
   * @param year release year
   */
  public Music(RecordingArtist artist, String title, int year) {
    super(artist, title, year);
  }

  /**
   * Constructs a music item with a band as creator.
   *
   * @param band band creator
   * @param title title
   * @param year release year
   */
  public Music(Band band, String title, int year) {
    super(band, title, year);
  }

  /**
   * Returns whether this music item matches the given recording artist.
   * The artist may be the sole creator, or a member of the band creator.
   *
   * @param artist recording artist to match
   * @return true if this music item matches the given artist
   */
  public boolean hasArtist(RecordingArtist artist) {
    if (artist == null) {
      throw new IllegalArgumentException("Artist cannot be null.");
    }

    Creator creator = getCreator();

    if (creator instanceof RecordingArtist) {
      return creator.equals(artist);
    }

    if (creator instanceof Band) {
      return ((Band) creator).hasMember(artist);
    }

    return false;
  }
}
