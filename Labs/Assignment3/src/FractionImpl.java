public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator; // invariant: always > 0

  /**
   * Constructs a fraction.
   *
   * @throws IllegalArgumentException if denominator <= 0
   */
  public FractionImpl(int numerator, int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    normalize(); // reduce + handle 0 + keep denom positive
  }

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setNumerator(int n) {
    this.numerator = n;
    normalize();
  }

  @Override
  public void setDenominator(int d) {
    if (d <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.denominator = d;
    normalize();
  }

  @Override
  public double toDouble() {
    return (double) numerator / (double) denominator;
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new IllegalArgumentException("Zero has no reciprocal.");
    }
    // swap; keep denom positive via constructor/normalize
    return new FractionImpl(denominator * (numerator < 0 ? -1 : 1), Math.abs(numerator));
  }

  @Override
  public Fraction add(Fraction other) {
    // use long to avoid overflow in intermediate multiplication
    long a = this.numerator;
    long b = this.denominator;
    long c = other.getNumerator();
    long d = other.getDenominator();

    long newNum = a * d + c * b;
    long newDen = b * d;

    return new FractionImpl((int) newNum, (int) newDen);
  }

  @Override
  public int compareTo(Fraction other) {
    long left = (long) this.numerator * (long) other.getDenominator();
    long right = (long) other.getNumerator() * (long) this.denominator;
    return Long.compare(left, right);
  }

  /**
   * Returns a string representation of this fraction in simplest form as "n/d". The denominator is
   * always positive.
   *
   * @return the simplified fraction string
   */
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  // ---- helpers ----

  /**
   * Reduces fraction, ensures denominator > 0, and normalizes 0 to 0/1.
   */
  private void normalize() {
    if (numerator == 0) {
      denominator = 1;
      return;
    }

    // denominator should already be positive due to checks, but keep robust:
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    int g = gcd(numerator, denominator);
    numerator /= g;
    denominator /= g;
  }

  private static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return (a == 0) ? 1 : a;
  }
}

