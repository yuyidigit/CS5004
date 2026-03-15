package problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores all items in the library and provides search functionality.
 */
public class Catalog {
  private List<Item> items;

  /**
   * Constructs an empty catalog.
   */
  public Catalog() {
    this.items = new ArrayList<>();
  }

  /**
   * Constructs a catalog with an initial collection of items.
   *
   * @param items initial items
   */
  public Catalog(List<Item> items) {
    if (items == null) {
      throw new IllegalArgumentException("Items cannot be null.");
    }
    for (Item item : items) {
      if (item == null) {
        throw new IllegalArgumentException("Items collection cannot contain null.");
      }
    }
    this.items = new ArrayList<>(items);
  }

  public List<Item> getItems() {
    return new ArrayList<>(items);
  }

  public void addItem(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null.");
    }
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  /**
   * Searches by keyword in title, case-insensitive.
   *
   * @param keyword keyword
   * @return matching items
   */
  public List<Item> search(String keyword) {
    if (keyword == null) {
      throw new IllegalArgumentException("Keyword cannot be null.");
    }

    List<Item> results = new ArrayList<>();
    for (Item item : items) {
      if (item.titleContains(keyword)) {
        results.add(item);
      }
    }
    return results;
  }

  /**
   * Searches for books by exact author match.
   *
   * @param author author to match
   * @return matching books
   */
  public List<Item> search(Author author) {
    if (author == null) {
      throw new IllegalArgumentException("Author cannot be null.");
    }

    List<Item> results = new ArrayList<>();
    for (Item item : items) {
      if (item instanceof Book) {
        Book book = (Book) item;
        if (book.getAuthor().equals(author)) {
          results.add(book);
        }
      }
    }
    return results;
  }

  /**
   * Searches for music by exact recording artist match.
   * The artist may be the sole creator or one member of a band.
   *
   * @param artist recording artist to match
   * @return matching music items
   */
  public List<Item> search(RecordingArtist artist) {
    if (artist == null) {
      throw new IllegalArgumentException("Recording artist cannot be null.");
    }

    List<Item> results = new ArrayList<>();
    for (Item item : items) {
      if (item instanceof Music) {
        Music music = (Music) item;
        if (music.hasArtist(artist)) {
          results.add(music);
        }
      }
    }
    return results;
  }
}
