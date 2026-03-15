package problem2;

/**
 * Represents a book.
 */
public class Book extends Item {

  /**
   * Constructs a book with an author as creator.
   *
   * @param author book author
   * @param title title
   * @param year publication year
   */
  public Book(Author author, String title, int year) {
    super(author, title, year);
  }

  public Author getAuthor() {
    return (Author) getCreator();
  }
}
