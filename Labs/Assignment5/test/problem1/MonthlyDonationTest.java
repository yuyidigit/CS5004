package problem1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonthlyDonationTest {

  @Test
  public void testNewMonthlyDonationStartsWithoutCancellationDate() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    assertNull(donation.getCancellationDateTime());
  }

  @Test
  public void testSetCancellationDateTimeSuccessfully() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    LocalDateTime cancelTime = LocalDateTime.of(2026, 6, 10, 8, 0);
    donation.setCancellationDateTime(cancelTime);

    assertEquals(cancelTime, donation.getCancellationDateTime());
  }

  @Test
  public void testSetCancellationDateTimeRejectsNull() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    assertThrows(IllegalArgumentException.class, () -> {
      donation.setCancellationDateTime(null);
    });
  }

  @Test
  public void testSetCancellationDateTimeRejectsEarlierThanCreation() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    assertThrows(IllegalArgumentException.class, () -> {
      donation.setCancellationDateTime(LocalDateTime.of(2026, 2, 9, 8, 0));
    });
  }

  @Test
  public void testGetAmountForYearBeforeCreationYearIsZero() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    assertEquals(0.0, donation.getAmountForYear(2025), 0.0001);
  }

  @Test
  public void testGetAmountForYearInCreationYearWithoutCancellation() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    // Feb through Dec = 11 occurrences
    assertEquals(110.0, donation.getAmountForYear(2026), 0.0001);
  }

  @Test
  public void testGetAmountForYearAfterCreationYearWithoutCancellation() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    // Full year in 2027 = 12 occurrences
    assertEquals(120.0, donation.getAmountForYear(2027), 0.0001);
  }

  @Test
  public void testGetAmountForYearWithCancellationInSameYear() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    // Counts Feb, Mar, Apr, May, Jun
    donation.setCancellationDateTime(LocalDateTime.of(2026, 6, 10, 8, 0));

    assertEquals(50.0, donation.getAmountForYear(2026), 0.0001);
  }

  @Test
  public void testGetAmountForYearWithCancellationInFollowingYear() {
    MonthlyDonation donation =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));

    donation.setCancellationDateTime(LocalDateTime.of(2027, 3, 10, 8, 0));

    // 2026: Feb through Dec = 11
    assertEquals(110.0, donation.getAmountForYear(2026), 0.0001);

    // 2027: Jan, Feb, Mar = 3
    assertEquals(30.0, donation.getAmountForYear(2027), 0.0001);
  }
}
