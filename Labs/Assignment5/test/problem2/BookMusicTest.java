package problem2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookMusicTest {

  @Test
  public void testBookConstruction() {
    Author author = new Author("George", "Orwell");
    Book book = new Book(author, "1984", 1949);

    assertEquals(author, book.getAuthor());
    assertEquals("1984", book.getTitle());
    assertEquals(1949, book.getYear());
    assertEquals(author, book.getCreator());
  }

  @Test
  public void testMusicConstructionWithRecordingArtist() {
    RecordingArtist artist = new RecordingArtist("Taylor", "Swift");
    Music music = new Music(artist, "Lover", 2019);

    assertEquals(artist, music.getCreator());
    assertEquals("Lover", music.getTitle());
    assertEquals(2019, music.getYear());
  }

  @Test
  public void testMusicConstructionWithBand() {
    RecordingArtist john = new RecordingArtist("John", "Lennon");
    RecordingArtist paul = new RecordingArtist("Paul", "McCartney");
    Band band = new Band("The Beatles", List.of(john, paul));

    Music music = new Music(band, "Hey Jude", 1968);

    assertEquals(band, music.getCreator());
    assertEquals("Hey Jude", music.getTitle());
    assertEquals(1968, music.getYear());
  }

  @Test
  public void testItemRejectsNullCreator() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Music((RecordingArtist) null, "Lover", 2019);
    });
  }

  @Test
  public void testItemRejectsEmptyTitle() {
    Author author = new Author("George", "Orwell");

    assertThrows(IllegalArgumentException.class, () -> {
      new Book(author, "   ", 1949);
    });
  }

  @Test
  public void testItemRejectsNonPositiveYear() {
    Author author = new Author("George", "Orwell");

    assertThrows(IllegalArgumentException.class, () -> {
      new Book(author, "1984", 0);
    });
  }

  @Test
  public void testTitleContainsIgnoresCase() {
    Author author = new Author("George", "Orwell");
    Book book = new Book(author, "Animal Farm", 1945);

    assertTrue(book.titleContains("animal"));
    assertTrue(book.titleContains("FARM"));
    assertFalse(book.titleContains("1984"));
  }

  @Test
  public void testMusicHasArtistWithDirectArtist() {
    RecordingArtist artist = new RecordingArtist("Taylor", "Swift");
    Music music = new Music(artist, "Lover", 2019);

    assertTrue(music.hasArtist(artist));
    assertFalse(music.hasArtist(new RecordingArtist("John", "Lennon")));
  }

  @Test
  public void testMusicHasArtistWithBandMember() {
    RecordingArtist john = new RecordingArtist("John", "Lennon");
    RecordingArtist paul = new RecordingArtist("Paul", "McCartney");
    Band band = new Band("The Beatles", List.of(john, paul));
    Music music = new Music(band, "Hey Jude", 1968);

    assertTrue(music.hasArtist(john));
    assertTrue(music.hasArtist(paul));
    assertFalse(music.hasArtist(new RecordingArtist("Taylor", "Swift")));
  }

  @Test
  public void testMusicHasArtistRejectsNull() {
    RecordingArtist artist = new RecordingArtist("Taylor", "Swift");
    Music music = new Music(artist, "Lover", 2019);

    assertThrows(IllegalArgumentException.class, () -> {
      music.hasArtist(null);
    });
  }
}
