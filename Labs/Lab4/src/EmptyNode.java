/**
 * Represents an empty list of books.
 */
public class EmptyNode implements IListOfBooks {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public float totalPrice() {
    return 0.0f;
  }

  @Override
  public IListOfBooks allBefore(int year) {
    return this; // empty list stays empty
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    if (book == null) {
      throw new IllegalArgumentException("book cannot be null");
    }
    return new ElementNode(book, this);
  }

  @Override
  public String toString() {
    return "";
  }
}

