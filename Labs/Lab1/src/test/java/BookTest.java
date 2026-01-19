import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
  private Book book1;
  private Book book2;
  private Book book3;

  @BeforeEach
  void setUp() {
    this.book1 = new Book("Clean Code", "Robert C. Martin", 464);
    this.book2 = new Book("Effective Java", "Joshua Bloch", 416);
    this.book3 = new Book("The Pragmatic Programmer", "Andrew Hunt", 352);
  }

  @Test
  void getTitle() {
    assertEquals("Clean Code", this.book1.getTitle());
    assertEquals("Effective Java", this.book2.getTitle());
    assertEquals("The Pragmatic Programmer", this.book3.getTitle());
  }

  @Test
  void getAuthor() {
    assertEquals("Robert C. Martin", this.book1.getAuthor());
    assertEquals("Joshua Bloch", this.book2.getAuthor());
    assertEquals("Andrew Hunt", this.book3.getAuthor());
  }

  @Test
  void getPages() {
    assertEquals(464, this.book1.getPages());
    assertEquals(416, this.book2.getPages());
    assertEquals(352, this.book3.getPages());
  }
}
