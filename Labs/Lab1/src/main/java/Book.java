/**
 * Represents a Book with its details--title, author, and number of pages.
 */
public class Book {
  private String title;
  private String author;
  private int pages;

  /**
   * Creates a new book given the book's title, author, and number of pages.
   *
   * @param title the book's title
   * @param author the book's author
   * @param pages the number of pages in the book
   */
  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @return the author
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * @return the number of pages
   */
  public int getPages() {
    return this.pages;
  }
}
