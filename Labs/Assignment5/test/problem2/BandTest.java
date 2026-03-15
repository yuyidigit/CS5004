package problem2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BandTest {

  @Test
  public void testBandConstruction() {
    RecordingArtist john = new RecordingArtist("John", "Lennon");
    RecordingArtist paul = new RecordingArtist("Paul", "McCartney");

    Band band = new Band("The Beatles", List.of(john, paul));

    assertEquals("The Beatles", band.getName());
    assertEquals("The Beatles", band.getDisplayName());
    assertEquals(2, band.getMembers().size());
  }

  @Test
  public void testBandRejectsNullName() {
    RecordingArtist john = new RecordingArtist("John", "Lennon");

    assertThrows(IllegalArgumentException.class, () -> {
      new Band(null, List.of(john));
    });
  }

  @Test
  public void testBandRejectsNullMembersList() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Band("The Beatles", null);
    });
  }

  @Test
  public void testBandRejectsNullMemberInsideList() {
    List<RecordingArtist> members = new ArrayList<>();
    members.add(new RecordingArtist("John", "Lennon"));
    members.add(null);

    assertThrows(IllegalArgumentException.class, () -> {
      new Band("The Beatles", members);
    });
  }

  @Test
  public void testHasMember() {
    RecordingArtist john = new RecordingArtist("John", "Lennon");
    RecordingArtist paul = new RecordingArtist("Paul", "McCartney");
    RecordingArtist taylor = new RecordingArtist("Taylor", "Swift");

    Band band = new Band("The Beatles", List.of(john, paul));

    assertTrue(band.hasMember(john));
    assertTrue(band.hasMember(paul));
    assertFalse(band.hasMember(taylor));
  }

  @Test
  public void testGetMembersReturnsCopy() {
    RecordingArtist john = new RecordingArtist("John", "Lennon");
    RecordingArtist paul = new RecordingArtist("Paul", "McCartney");

    Band band = new Band("The Beatles", List.of(john, paul));

    List<RecordingArtist> copy = band.getMembers();
    copy.clear();

    assertEquals(2, band.getMembers().size());
  }
}
