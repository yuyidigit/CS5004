package Problem2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Problem2BasicTest {

  private StringList empty() {
    return new EmptyStringList();
  }

  private StringList list(String... items) {
    StringList result = empty();
    for (int i = items.length - 1; i >= 0; i--) {
      result = new ConsStringList(items[i], result);
    }
    return result;
  }

  @Test
  public void testIsEmptyAndSize() {
    assertTrue(empty().isEmpty());
    assertEquals(0, empty().size());

    StringList l = list("a", "bb", "ccc");
    assertFalse(l.isEmpty());
    assertEquals(3, l.size());
  }

  @Test
  public void testContains() {
    StringList l = list("a", "bb", "ccc");
    assertTrue(l.contains("bb"));
    assertFalse(l.contains("dddd"));
  }

  @Test
  public void testContainsAll() {
    StringList l = list("a", "bb", "ccc");
    assertTrue(l.containsAll(list()));
    assertTrue(l.containsAll(list("a", "ccc")));
    assertFalse(l.containsAll(list("a", "x")));
  }

  @Test
  public void testFilterLargerThan() {
    StringList l = list("a", "bb", "ccc", "dddd");
    StringList filtered = l.filterLargerThan(2); // 删掉长度>2
    assertEquals(2, filtered.size());
    assertTrue(filtered.contains("a"));
    assertTrue(filtered.contains("bb"));
    assertFalse(filtered.contains("ccc"));
    assertFalse(filtered.contains("dddd"));
  }

  @Test
  public void testDuplicatesAndRemove() {
    StringList l1 = list("a", "bb", "ccc");
    assertFalse(l1.hasDuplicates());
    assertEquals(3, l1.removeDuplicates().size());

    StringList l2 = list("a", "bb", "a", "bb", "ccc");
    assertTrue(l2.hasDuplicates());
    StringList rd = l2.removeDuplicates();
    assertEquals(3, rd.size());
    assertTrue(rd.contains("a"));
    assertTrue(rd.contains("bb"));
    assertTrue(rd.contains("ccc"));
  }

  @Test
  public void testExceptions() {
    assertThrows(IllegalArgumentException.class, () -> empty().contains(null));
    assertThrows(IllegalArgumentException.class, () -> empty().containsAll(null));
    assertThrows(IllegalArgumentException.class, () -> empty().filterLargerThan(-1));
  }
}

