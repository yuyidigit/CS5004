package problem2;

import java.util.Objects;

/**
 * Abstract parent class for all library items.
 */
public abstract class Item {
  private Creator creator;
  private String title;
  private int year;

  /**
   * Constructs an item.
   *
   * @param creator item creator
   * @param title item title
   * @param year release/publication year
   */
  public Item(Creator creator, String title, int year) {
    if (creator == null) {
      throw new IllegalArgumentException("Creator cannot be null.");
    }
    if (title == null || title.trim().isEmpty()) {
      throw new IllegalArgumentException("Title cannot be null or empty.");
    }
    if (year <= 0) {
      throw new IllegalArgumentException("Year must be positive.");
    }

    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  public Creator getCreator() {
    return creator;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  /**
   * Returns true if the title contains the keyword, ignoring case.
   *
   * @param keyword keyword
   * @return true if match found
   */
  public boolean titleContains(String keyword) {
    if (keyword == null) {
      throw new IllegalArgumentException("Keyword cannot be null.");
    }
    return title.toLowerCase().contains(keyword.toLowerCase());
  }

  @Override
  public String toString() {
    return title + " (" + year + ") by " + creator.getDisplayName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return year == item.year
        && Objects.equals(creator, item.creator)
        && Objects.equals(title, item.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creator, title, year, getClass());
  }
}
