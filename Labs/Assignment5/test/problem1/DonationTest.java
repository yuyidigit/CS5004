package problem1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DonationTest {

  /**
   * A simple concrete subclass so we can test the abstract Donation constructor/getters.
   */
  private static class TestDonation extends Donation {
    public TestDonation(double amount, LocalDateTime creationDateTime) {
      super(amount, creationDateTime);
    }

    @Override
    public double getAmountForYear(int year) {
      return 0;
    }
  }

  @Test
  public void testValidDonationConstruction() {
    LocalDateTime created = LocalDateTime.of(2026, 3, 10, 12, 0);
    Donation donation = new TestDonation(50.0, created);

    assertEquals(50.0, donation.getAmount(), 0.0001);
    assertEquals(created, donation.getCreationDateTime());
  }

  @Test
  public void testConstructorRejectsZeroAmount() {
    LocalDateTime created = LocalDateTime.of(2026, 3, 10, 12, 0);

    assertThrows(IllegalArgumentException.class, () -> {
      new TestDonation(0, created);
    });
  }

  @Test
  public void testConstructorRejectsNegativeAmount() {
    LocalDateTime created = LocalDateTime.of(2026, 3, 10, 12, 0);

    assertThrows(IllegalArgumentException.class, () -> {
      new TestDonation(-5, created);
    });
  }

  @Test
  public void testConstructorRejectsNullCreationDateTime() {
    assertThrows(IllegalArgumentException.class, () -> {
      new TestDonation(25.0, null);
    });
  }
}
