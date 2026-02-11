/**
 * Represents a non-empty list node containing one book and the rest of the list.
 */
public class ElementNode implements IListOfBooks {
  private final Book first;
  private final IListOfBooks rest;

  /**
   * Construct an ElementNode with a first book and the rest of the list.
   *
   * @param first the book stored in this node
   * @param rest  the remaining list
   */
  public ElementNode(Book first, IListOfBooks rest) {
    if (first == null) {
      throw new IllegalArgumentException("first cannot be null");
    }
    if (rest == null) {
      throw new IllegalArgumentException("rest cannot be null");
    }
    this.first = first;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + this.rest.count();
  }

  @Override
  public float totalPrice() {
    return this.first.getPrice() + this.rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (this.first.before(year)) {
      return new ElementNode(this.first, this.rest.allBefore(year));
    }
    return this.rest.allBefore(year);
  }

  @Override
  public IListOfBooks addAtEnd(Book book) {
    if (book == null) {
      throw new IllegalArgumentException("book cannot be null");
    }
    return new ElementNode(this.first, this.rest.addAtEnd(book));
  }

  @Override
  public String toString() {
    String restStr = this.rest.toString();
    if (restStr.isEmpty()) {
      return this.first.toString();
    }
    return this.first.toString() + "\n" + restStr;
  }
}

