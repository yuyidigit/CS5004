/**
 * Represents an immutable-like fraction abstraction with an integer numerator
 * and a positive integer denominator.
 */
public interface Fraction extends Comparable<Fraction> {

  /** @return the numerator (may be negative, zero, or positive). */
  int getNumerator();

  /** @return the denominator (always positive). */
  int getDenominator();

  /**
   * Sets the numerator.
   * @param n new numerator
   */
  void setNumerator(int n);

  /**
   * Sets the denominator. Denominator must remain positive.
   * @param d new denominator (must be > 0)
   * @throws IllegalArgumentException if d <= 0
   */
  void setDenominator(int d);

  /** @return the decimal value of this fraction. */
  double toDouble();

  /**
   * @return the reciprocal of this fraction.
   * @throws IllegalArgumentException if numerator is 0
   */
  Fraction reciprocal();

  /**
   * Adds this fraction and other.
   * @param other another fraction (assume non-null unless your spec says otherwise)
   * @return simplified result
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction with other.
   * @return negative if this < other, 0 if equal, positive if this > other
   */
  @Override
  int compareTo(Fraction other);
}

