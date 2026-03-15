package problem1;

import java.time.LocalDateTime;

/**
 * Represents a pledge donation.
 * A pledge may or may not have a processing date/time.
 */
public class Pledge extends Donation {
  private LocalDateTime processingDateTime;

  /**
   * Constructs a pledge with no processing date/time yet.
   *
   * @param amount the pledged amount
   * @param creationDateTime the creation date/time
   */
  public Pledge(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.processingDateTime = null;
  }

  /**
   * Constructs a pledge with a processing date/time.
   *
   * @param amount the pledged amount
   * @param creationDateTime the creation date/time
   * @param processingDateTime the processing date/time
   */
  public Pledge(double amount,
      LocalDateTime creationDateTime,
      LocalDateTime processingDateTime) {
    super(amount, creationDateTime);
    setProcessingDateTime(processingDateTime);
  }

  /**
   * Returns the processing date/time, or null if not set.
   *
   * @return the processing date/time
   */
  public LocalDateTime getProcessingDateTime() {
    return processingDateTime;
  }

  /**
   * Sets or updates the processing date/time.
   * The processing date/time may also be removed by passing null to removeProcessingDateTime().
   *
   * @param processingDateTime the new processing date/time
   * @throws IllegalArgumentException if processingDateTime is before creationDateTime
   */
  public void setProcessingDateTime(LocalDateTime processingDateTime) {
    if (processingDateTime == null) {
      throw new IllegalArgumentException("Use removeProcessingDateTime() to remove the date.");
    }

    if (processingDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException(
          "Processing date/time cannot be before creation date/time.");
    }

    this.processingDateTime = processingDateTime;
  }

  /**
   * Removes the processing date/time.
   */
  public void removeProcessingDateTime() {
    this.processingDateTime = null;
  }

  @Override
  public double getAmountForYear(int year) {
    if (processingDateTime == null) {
      return 0;
    }

    if (processingDateTime.getYear() == year) {
      return getAmount();
    }

    return 0;
  }
}
