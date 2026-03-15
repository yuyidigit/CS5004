package problem1;

import java.time.LocalDateTime;

/**
 * Abstract parent class for all donation types.
 */
public abstract class Donation {
  private double amount;
  private LocalDateTime creationDateTime;

  /**
   * Constructs a donation with an amount and creation date/time.
   *
   * @param amount the donation amount
   * @param creationDateTime the date/time the donation was created
   * @throws IllegalArgumentException if amount is not positive
   * @throws IllegalArgumentException if creationDateTime is null
   */
  public Donation(double amount, LocalDateTime creationDateTime) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount must be positive.");
    }
    if (creationDateTime == null) {
      throw new IllegalArgumentException("Creation date/time cannot be null.");
    }
    this.amount = amount;
    this.creationDateTime = creationDateTime;
  }

  /**
   * Returns the donation amount.
   *
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns the creation date/time.
   *
   * @return the creation date/time
   */
  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  /**
   * Returns how much this donation contributes to the given year.
   * Different donation subtypes implement different rules.
   *
   * @param year the target year
   * @return the amount counted for that year
   */
  public abstract double getAmountForYear(int year);
}
