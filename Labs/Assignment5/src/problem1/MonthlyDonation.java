package problem1;

import java.time.LocalDateTime;

/**
 * Represents a recurring monthly donation.
 */
public class MonthlyDonation extends Donation {
  private LocalDateTime cancellationDateTime;

  /**
   * Constructs a monthly donation.
   * A monthly donation starts with no cancellation date.
   *
   * @param amount the monthly donation amount
   * @param creationDateTime the starting date/time
   */
  public MonthlyDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.cancellationDateTime = null;
  }

  /**
   * Returns the cancellation date/time, or null if not cancelled.
   *
   * @return the cancellation date/time
   */
  public LocalDateTime getCancellationDateTime() {
    return cancellationDateTime;
  }

  /**
   * Sets the cancellation date/time.
   *
   * @param cancellationDateTime the cancellation date/time
   * @throws IllegalArgumentException if cancellationDateTime is before creationDateTime
   */
  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (cancellationDateTime == null) {
      throw new IllegalArgumentException("Cancellation date/time cannot be null.");
    }
    if (cancellationDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException(
          "Cancellation date/time cannot be before creation date/time.");
    }
    this.cancellationDateTime = cancellationDateTime;
  }

  @Override
  public double getAmountForYear(int year) {
    if (year < getCreationDateTime().getYear()) {
      return 0;
    }

    double total = 0;
    LocalDateTime occurrence = getCreationDateTime();

    while (occurrence.getYear() <= year) {
      if (cancellationDateTime != null && occurrence.isAfter(cancellationDateTime)) {
        break;
      }

      if (occurrence.getYear() == year) {
        total += getAmount();
      }

      occurrence = occurrence.plusMonths(1);
    }

    return total;
  }
}
