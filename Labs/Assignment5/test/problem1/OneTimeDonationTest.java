package problem1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneTimeDonationTest {

  @Test
  public void testAmountIncludedInCreationYear() {
    OneTimeDonation donation =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 4, 5, 9, 30));

    assertEquals(100.0, donation.getAmountForYear(2026), 0.0001);
  }

  @Test
  public void testAmountNotIncludedInDifferentYear() {
    OneTimeDonation donation =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 4, 5, 9, 30));

    assertEquals(0.0, donation.getAmountForYear(2025), 0.0001);
    assertEquals(0.0, donation.getAmountForYear(2027), 0.0001);
  }
}
