import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IListOfBooksTest {
  private static final float EPS = 0.0001f;

  private final Book b1 = new Book("A", "Alice", 1999, 10.00f);
  private final Book b2 = new Book("B", "Bob", 2005, 20.00f);
  private final Book b3 = new Book("C", "Cathy", 1980, 5.50f);
  private final Book b4 = new Book("D", "Dan", 2010, 7.25f);

  private final IListOfBooks empty = new EmptyNode();
  private final IListOfBooks one = new ElementNode(b1, empty);
  private final IListOfBooks three = new ElementNode(b1, new ElementNode(b2, new ElementNode(b3, empty)));

  // -------- EmptyNode tests (5 methods × 2 assertions) --------

  @Test
  public void testEmptyCount() {
    assertEquals(0, empty.count());
    assertEquals(0, new EmptyNode().count());
  }

  @Test
  public void testEmptyTotalPrice() {
    assertEquals(0.0f, empty.totalPrice(), EPS);
    assertEquals(0.0f, new EmptyNode().totalPrice(), EPS);
  }

  @Test
  public void testEmptyAllBefore() {
    assertEquals(0, empty.allBefore(2000).count());
    assertEquals("", empty.allBefore(0).toString());
  }

  @Test
  public void testEmptyAddAtEnd() {
    IListOfBooks added = empty.addAtEnd(b1);
    assertEquals(1, added.count());
    assertEquals(b1.getPrice(), added.totalPrice(), EPS);
  }

  @Test
  public void testEmptyToString() {
    assertEquals("", empty.toString());
    assertTrue(empty.toString().isEmpty());
  }

  // -------- ElementNode tests (5 methods × 2 assertions) --------

  @Test
  public void testElementCount() {
    assertEquals(3, three.count());
    assertEquals(1, one.count());
  }

  @Test
  public void testElementTotalPrice() {
    assertEquals(b1.getPrice() + b2.getPrice() + b3.getPrice(), three.totalPrice(), EPS);
    assertEquals(b1.getPrice(), one.totalPrice(), EPS);
  }

  @Test
  public void testElementAllBefore() {
    IListOfBooks before2000 = three.allBefore(2000); // should keep b1(1999) and b3(1980)
    assertEquals(2, before2000.count());
    assertEquals(b1.getPrice() + b3.getPrice(), before2000.totalPrice(), EPS);

    IListOfBooks before1985 = three.allBefore(1985); // should keep only b3(1980)
    assertEquals(1, before1985.count());
    assertEquals(b3.toString(), before1985.toString());
  }

  @Test
  public void testElementAddAtEnd() {
    IListOfBooks appended = three.addAtEnd(b4);
    assertEquals(4, appended.count());
    assertTrue(appended.toString().endsWith(b4.toString()));
  }

  @Test
  public void testElementToString() {
    assertEquals(b1.toString(), one.toString());
    assertEquals(b1.toString() + "\n" + b2.toString() + "\n" + b3.toString(), three.toString());
  }
}

