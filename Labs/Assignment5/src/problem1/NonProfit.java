package problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a non-profit organization that tracks donations.
 */
public class NonProfit {
  private String name;
  private List<Donation> donations;

  /**
   * Constructs a non-profit with an empty donation list.
   *
   * @param name the organization name
   */
  public NonProfit(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = name;
    this.donations = new ArrayList<>();
  }

  /**
   * Returns the organization name.
   *
   * @return the organization name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns a copy of the donation list.
   *
   * @return a copy of donations
   */
  public List<Donation> getDonations() {
    return new ArrayList<>(donations);
  }

  /**
   * Adds a donation to the non-profit.
   *
   * @param donation the donation to add
   * @throws IllegalArgumentException if donation is null
   */
  public void addDonation(Donation donation) {
    if (donation == null) {
      throw new IllegalArgumentException("Donation cannot be null.");
    }
    donations.add(donation);
  }

  /**
   * Removes a donation from the non-profit.
   *
   * @param donation the donation to remove
   */
  public void removeDonation(Donation donation) {
    donations.remove(donation);
  }

  /**
   * Returns the total amount of donations processed in the given year.
   *
   * @param year the target year
   * @return the total donations for that year
   */
  public double getTotalDonationsForYear(int year) {
    double total = 0;

    for (Donation donation : donations) {
      total += donation.getAmountForYear(year);
    }

    return total;
  }
}
