package problem1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NonProfitTest {

  @Test
  public void testConstructorStoresName() {
    NonProfit nonProfit = new NonProfit("Helping Hands");

    assertEquals("Helping Hands", nonProfit.getName());
  }

  @Test
  public void testConstructorRejectsNullName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new NonProfit(null);
    });
  }

  @Test
  public void testConstructorRejectsEmptyName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new NonProfit("   ");
    });
  }

  @Test
  public void testAddDonationRejectsNull() {
    NonProfit nonProfit = new NonProfit("Helping Hands");

    assertThrows(IllegalArgumentException.class, () -> {
      nonProfit.addDonation(null);
    });
  }

  @Test
  public void testAddDonationAndGetDonations() {
    NonProfit nonProfit = new NonProfit("Helping Hands");
    Donation donation =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    nonProfit.addDonation(donation);

    List<Donation> donations = nonProfit.getDonations();
    assertEquals(1, donations.size());
    assertEquals(donation, donations.get(0));
  }

  @Test
  public void testGetDonationsReturnsCopy() {
    NonProfit nonProfit = new NonProfit("Helping Hands");
    Donation donation =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    nonProfit.addDonation(donation);

    List<Donation> copy = nonProfit.getDonations();
    copy.clear();

    // Original internal list should remain unchanged
    assertEquals(1, nonProfit.getDonations().size());
  }

  @Test
  public void testRemoveDonation() {
    NonProfit nonProfit = new NonProfit("Helping Hands");
    Donation donation =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    nonProfit.addDonation(donation);
    nonProfit.removeDonation(donation);

    assertEquals(0, nonProfit.getDonations().size());
  }

  @Test
  public void testGetTotalDonationsForYearWithMixedDonations() {
    NonProfit nonProfit = new NonProfit("Helping Hands");

    Donation oneTime =
        new OneTimeDonation(100.0, LocalDateTime.of(2026, 3, 1, 10, 0));

    MonthlyDonation monthly =
        new MonthlyDonation(10.0, LocalDateTime.of(2026, 2, 10, 8, 0));
    // 2026: Feb through Dec = 11 occurrences = 110

    Pledge pledge =
        new Pledge(
            500.0,
            LocalDateTime.of(2026, 5, 1, 12, 0),
            LocalDateTime.of(2027, 1, 15, 8, 0));

    nonProfit.addDonation(oneTime);
    nonProfit.addDonation(monthly);
    nonProfit.addDonation(pledge);

    assertEquals(210.0, nonProfit.getTotalDonationsForYear(2026), 0.0001);
    assertEquals(620.0, nonProfit.getTotalDonationsForYear(2027), 0.0001);
  }

  @Test
  public void testGetTotalDonationsForYearWithNoDonations() {
    NonProfit nonProfit = new NonProfit("Helping Hands");

    assertEquals(0.0, nonProfit.getTotalDonationsForYear(2026), 0.0001);
  }
}
