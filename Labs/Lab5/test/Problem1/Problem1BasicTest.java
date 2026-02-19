package Problem1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Problem1BasicTest {

  @Test
  public void testReceiveAwardAppends() {
    Poet p = new Poet(
        new Name("Li", "Bai"),
        30,
        new String[]{"romantic"},
        new String[]{"A1"},
        "PubCo",
        "Collection1"
    );

    p.receiveAward("A2");
    assertArrayEquals(new String[]{"A1", "A2"}, p.getAwards());
  }

  @Test
  public void testAgeLowerBoundOk() {
    Painter painter = new Painter(
        new Name("A", "B"),
        0,
        new String[]{"modern"},
        new String[0],
        new String[]{"Exhibit1"}
    );
    assertEquals(0, painter.getAge());
  }

  @Test
  public void testAgeUpperBoundOk() {
    Photographer ph = new Photographer(
        new Name("A", "B"),
        128,
        new String[]{"doc"},
        new String[0],
        new String[]{"Ex1"}
    );
    assertEquals(128, ph.getAge());
  }

  @Test
  public void testAgeTooSmallThrows() {
    assertThrows(IllegalArgumentException.class, () ->
        new Musician(
            new Name("A", "B"),
            -1,
            new String[]{"pop"},
            new String[0],
            "RC",
            "Album"
        )
    );
  }

  @Test
  public void testAgeTooLargeThrows() {
    assertThrows(IllegalArgumentException.class, () ->
        new Actor(
            new Name("A", "B"),
            129,
            new String[]{"drama"},
            new String[0],
            new String[]{"M1"},
            new String[]{"S1"},
            new String[]{"O1"}
        )
    );
  }
}

