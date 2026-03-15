package problem1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PledgeTest {

  @Test
  public void testPledgeWithoutProcessingDateStartsAsNull() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 5, 1, 12, 0));

    assertNull(pledge.getProcessingDateTime());
  }

  @Test
  public void testPledgeWithoutProcessingDateReturnsZeroForAnyYear() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 5, 1, 12, 0));

    assertEquals(0.0, pledge.getAmountForYear(2026), 0.0001);
    assertEquals(0.0, pledge.getAmountForYear(2027), 0.0001);
  }

  @Test
  public void testPledgeConstructorWithProcessingDate() {
    LocalDateTime created = LocalDateTime.of(2026, 5, 1, 12, 0);
    LocalDateTime processed = LocalDateTime.of(2027, 1, 15, 8, 0);

    Pledge pledge = new Pledge(500.0, created, processed);

    assertEquals(processed, pledge.getProcessingDateTime());
    assertEquals(500.0, pledge.getAmountForYear(2027), 0.0001);
    assertEquals(0.0, pledge.getAmountForYear(2026), 0.0001);
  }

  @Test
  public void testSetProcessingDateTimeSuccessfully() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 5, 1, 12, 0));

    LocalDateTime processed = LocalDateTime.of(2027, 1, 15, 8, 0);
    pledge.setProcessingDateTime(processed);

    assertEquals(processed, pledge.getProcessingDateTime());
    assertEquals(500.0, pledge.getAmountForYear(2027), 0.0001);
  }

  @Test
  public void testSetProcessingDateTimeRejectsNull() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 5, 1, 12, 0));

    assertThrows(IllegalArgumentException.class, () -> {
      pledge.setProcessingDateTime(null);
    });
  }

  @Test
  public void testSetProcessingDateTimeRejectsEarlierThanCreation() {
    Pledge pledge =
        new Pledge(500.0, LocalDateTime.of(2026, 5, 1, 12, 0));

    assertThrows(IllegalArgumentException.class, () -> {
      pledge.setProcessingDateTime(LocalDateTime.of(2026, 4, 30, 12, 0));
    });
  }

  @Test
  public void testRemoveProcessingDateTime() {
    Pledge pledge =
        new Pledge(
            500.0,
            LocalDateTime.of(2026, 5, 1, 12, 0),
            LocalDateTime.of(2027, 1, 15, 8, 0));

    pledge.removeProcessingDateTime();

    assertNull(pledge.getProcessingDateTime());
    assertEquals(0.0, pledge.getAmountForYear(2027), 0.0001);
  }
}
