import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FractionImplTest {

  // ---------- Constructor / normalization ----------

  @Test
  void constructorRejectsZeroOrNegativeDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, -2));
  }

  @Test
  void constructorSimplifiesAndKeepsDenominatorPositive() {
    Fraction f = new FractionImpl(4, 2);
    assertEquals(2, f.getNumerator());
    assertEquals(1, f.getDenominator());
    assertEquals("2/1", f.toString());
  }

  @Test
  void constructorHandlesNegativeFractionSignOnNumerator() {
    Fraction f = new FractionImpl(-2, 4); // should simplify to -1/2
    assertEquals(-1, f.getNumerator());
    assertEquals(2, f.getDenominator());
    assertEquals("-1/2", f.toString());
  }

  @Test
  void zeroAlwaysNormalizesToZeroOverOne() {
    Fraction f = new FractionImpl(0, 5);
    assertEquals(0, f.getNumerator());
    assertEquals(1, f.getDenominator());
    assertEquals("0/1", f.toString());
  }

  // ---------- Getters / setters ----------

  @Test
  void setDenominatorRejectsNonPositiveAndDoesNotChangeState() {
    FractionImpl f = new FractionImpl(1, 2);

    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    assertEquals(1, f.getNumerator());
    assertEquals(2, f.getDenominator());

    assertThrows(IllegalArgumentException.class, () -> f.setDenominator(-3));
    assertEquals(1, f.getNumerator());
    assertEquals(2, f.getDenominator());
  }

  @Test
  void settersTriggerNormalization() {
    FractionImpl f = new FractionImpl(2, 4); // will become 1/2
    assertEquals("1/2", f.toString());

    f.setNumerator(4);   // 4/2 -> 2/1
    assertEquals("2/1", f.toString());

    f.setDenominator(10); // 2/10 -> 1/5
    assertEquals(1, f.getNumerator());
    assertEquals(5, f.getDenominator());
    assertEquals("1/5", f.toString());
  }

  // ---------- toDouble ----------

  @Test
  void toDoubleWorksForPositiveNegativeAndZero() {
    assertEquals(0.5, new FractionImpl(1, 2).toDouble(), 1e-10);
    assertEquals(-0.5, new FractionImpl(-1, 2).toDouble(), 1e-10);
    assertEquals(0.0, new FractionImpl(0, 7).toDouble(), 1e-10);
  }

  // ---------- reciprocal ----------

  @Test
  void reciprocalThrowsOnZeroNumerator() {
    Fraction f = new FractionImpl(0, 3);
    assertThrows(IllegalArgumentException.class, f::reciprocal);
  }

  @Test
  void reciprocalWorksAndPreservesSignRules() {
    Fraction a = new FractionImpl(2, 3).reciprocal();   // 3/2
    assertEquals("3/2", a.toString());

    Fraction b = new FractionImpl(-2, 3).reciprocal();  // -3/2
    assertEquals("-3/2", b.toString());
  }

  // ---------- add ----------

  @Test
  void addSameDenominator() {
    Fraction result = new FractionImpl(1, 3).add(new FractionImpl(1, 3));
    assertEquals("2/3", result.toString());
  }

  @Test
  void addDifferentDenominatorAndSimplifies() {
    Fraction result = new FractionImpl(1, 2).add(new FractionImpl(1, 3)); // 5/6
    assertEquals("5/6", result.toString());

    Fraction result2 = new FractionImpl(1, 6).add(new FractionImpl(1, 6)); // 2/6 -> 1/3
    assertEquals("1/3", result2.toString());
  }

  @Test
  void addWithNegativesCanProduceZero() {
    Fraction result = new FractionImpl(1, 2).add(new FractionImpl(-1, 2));
    assertEquals("0/1", result.toString());
  }

  // ---------- compareTo ----------

  @Test
  void compareToHandlesLessEqualGreater() {
    Fraction a = new FractionImpl(1, 2);
    Fraction b = new FractionImpl(2, 3);
    Fraction c = new FractionImpl(2, 4); // equals 1/2

    assertTrue(a.compareTo(b) < 0);
    assertTrue(b.compareTo(a) > 0);
    assertEquals(0, a.compareTo(c));
  }

  @Test
  void compareToHandlesNegativeAndZero() {
    Fraction neg = new FractionImpl(-1, 2);
    Fraction zero = new FractionImpl(0, 5);
    Fraction pos = new FractionImpl(1, 2);

    assertTrue(neg.compareTo(zero) < 0);
    assertTrue(zero.compareTo(pos) < 0);
    assertTrue(pos.compareTo(neg) > 0);
  }
}

