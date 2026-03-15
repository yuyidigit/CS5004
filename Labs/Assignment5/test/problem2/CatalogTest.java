package problem2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CatalogTest {

  @Test
  public void testEmptyCatalogConstruction() {
    Catalog catalog = new Catalog();

    assertEquals(0, catalog.getItems().size());
  }

  @Test
  public void testCatalogConstructionWithItems() {
    Author author = new Author("George", "Orwell");
    Book book = new Book(author, "1984", 1949);

    Catalog catalog = new Catalog(List.of(book));

    assertEquals(1, catalog.getItems().size());
    assertEquals(book, catalog.getItems().get(0));
  }

  @Test
  public void testCatalogRejectsNullItemsList() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Catalog(null);
    });
  }

  @Test
  public void testAddItemRejectsNull() {
    Catalog catalog = new Catalog();

    assertThrows(IllegalArgumentException.class, () -> {
      catalog.addItem(null);
    });
  }

  @Test
  public void testAddAndRemoveItem() {
    Catalog catalog = new Catalog();
    Author author = new Author("George", "Orwell");
    Book book = new Book(author, "1984", 1949);

    catalog.addItem(book);
    assertEquals(1, catalog.getItems().size());

    catalog.removeItem(book);
    assertEquals(0, catalog.getItems().size());
  }

  @Test
  public void testGetItemsReturnsCopy() {
    Catalog catalog = new Catalog();
    Author author = new Author("George", "Orwell");
    Book book = new Book(author, "1984", 1949);

    catalog.addItem(book);

    List<Item> copy = catalog.getItems();
    copy.clear();

    assertEquals(1, catalog.getItems().size());
  }

  @Test
  public void testSearchByKeywordIgnoresCase() {
    Catalog catalog = new Catalog();

    Book book1 = new Book(new Author("George", "Orwell"), "Animal Farm", 1945);
    Book book2 = new Book(new Author("George", "Orwell"), "1984", 1949);
    Music music = new Music(new RecordingArtist("Taylor", "Swift"), "Farmhouse", 2020);

    catalog.addItem(book1);
    catalog.addItem(book2);
    catalog.addItem(music);

    List<Item> results = catalog.search("farm");

    assertEquals(2, results.size());
  }

  @Test
  public void testSearchByAuthorReturnsOnlyBooks() {
    Catalog catalog = new Catalog();

    Author orwell = new Author("George", "Orwell");
    Author austen = new Author("Jane", "Austen");

    Book b1 = new Book(orwell, "1984", 1949);
    Book b2 = new Book(orwell, "Animal Farm", 1945);
    Book b3 = new Book(austen, "Pride and Prejudice", 1813);

    Music m1 = new Music(new RecordingArtist("George", "Orwell"), "Fake Album", 2020);

    catalog.addItem(b1);
    catalog.addItem(b2);
    catalog.addItem(b3);
    catalog.addItem(m1);

    List<Item> results = catalog.search(orwell);

    assertEquals(2, results.size());
    assertEquals(b1, results.get(0));
    assertEquals(b2, results.get(1));
  }

  @Test
  public void testSearchByRecordingArtistFindsDirectAndBandMusic() {
    Catalog catalog = new Catalog();

    RecordingArtist john = new RecordingArtist("John", "Lennon");
    RecordingArtist paul = new RecordingArtist("Paul", "McCartney");
    RecordingArtist taylor = new RecordingArtist("Taylor", "Swift");

    Band beatles = new Band("The Beatles", List.of(john, paul));

    Music m1 = new Music(john, "Imagine", 1971);
    Music m2 = new Music(beatles, "Hey Jude", 1968);
    Music m3 = new Music(taylor, "Lover", 2019);
    Book b1 = new Book(new Author("George", "Orwell"), "1984", 1949);

    catalog.addItem(m1);
    catalog.addItem(m2);
    catalog.addItem(m3);
    catalog.addItem(b1);

    List<Item> johnResults = catalog.search(john);
    assertEquals(2, johnResults.size());

    List<Item> taylorResults = catalog.search(taylor);
    assertEquals(1, taylorResults.size());
    assertEquals(m3, taylorResults.get(0));
  }

  @Test
  public void testSearchKeywordRejectsNull() {
    Catalog catalog = new Catalog();

    assertThrows(IllegalArgumentException.class, () -> {
      catalog.search((String) null);
    });
  }

  @Test
  public void testSearchAuthorRejectsNull() {
    Catalog catalog = new Catalog();

    assertThrows(IllegalArgumentException.class, () -> {
      catalog.search((Author) null);
    });
  }

  @Test
  public void testSearchRecordingArtistRejectsNull() {
    Catalog catalog = new Catalog();

    assertThrows(IllegalArgumentException.class, () -> {
      catalog.search((RecordingArtist) null);
    });
  }
}
