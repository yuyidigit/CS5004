package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreatorHierarchyTest {

  @Test
  public void testAuthorConstruction() {
    Author author = new Author("George", "Orwell");

    assertEquals("George", author.getFirstName());
    assertEquals("Orwell", author.getLastName());
    assertEquals("George Orwell", author.getDisplayName());
  }

  @Test
  public void testRecordingArtistConstruction() {
    RecordingArtist artist = new RecordingArtist("Taylor", "Swift");

    assertEquals("Taylor", artist.getFirstName());
    assertEquals("Swift", artist.getLastName());
    assertEquals("Taylor Swift", artist.getDisplayName());
  }

  @Test
  public void testIndividualRejectsNullFirstName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Author(null, "Orwell");
    });
  }

  @Test
  public void testIndividualRejectsEmptyLastName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new RecordingArtist("Taylor", "   ");
    });
  }

  @Test
  public void testAuthorEquality() {
    Author a1 = new Author("George", "Orwell");
    Author a2 = new Author("George", "Orwell");

    assertEquals(a1, a2);
    assertEquals(a1.hashCode(), a2.hashCode());
  }

  @Test
  public void testRecordingArtistEquality() {
    RecordingArtist r1 = new RecordingArtist("John", "Lennon");
    RecordingArtist r2 = new RecordingArtist("John", "Lennon");

    assertEquals(r1, r2);
    assertEquals(r1.hashCode(), r2.hashCode());
  }
}
