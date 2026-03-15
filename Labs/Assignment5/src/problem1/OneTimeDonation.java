package problem1;

import java.time.LocalDateTime;

/**
 * Represents a one-time donation.
 */
public class OneTimeDonation extends Donation {

  /**
   * Constructs a one-time donation.
   *
   * @param amount the donation amount
   * @param creationDateTime the donation date/time
   */
  public OneTimeDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  @Override
  public double getAmountForYear(int year) {
    if (getCreationDateTime().getYear() == year) {
      return getAmount();
    }
    return 0;
  }
}
