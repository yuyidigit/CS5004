package Problem2;


import java.util.Objects;

public class ConsStringList implements StringList {

  private final String first;
  private final StringList rest;

  public ConsStringList(String first, StringList rest) {
    if (first == null || rest == null) {
      throw new IllegalArgumentException("first/rest cannot be null");
    }
    this.first = first;
    this.rest = rest;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 1 + rest.size();
  }

  @Override
  public boolean contains(String s) {
    if (s == null) {
      throw new IllegalArgumentException("s cannot be null");
    }
    return first.equals(s) || rest.contains(s);
  }

  @Override
  public boolean containsAll(StringList other) {
    if (other == null) {
      throw new IllegalArgumentException("other cannot be null");
    }
    if (other.isEmpty()) {
      return true;
    }
    if (!(other instanceof ConsStringList)) {
      throw new IllegalArgumentException("Unknown StringList implementation");
    }
    ConsStringList o = (ConsStringList) other;
    return this.contains(o.first) && this.containsAll(o.rest);
  }

  @Override
  public StringList filterLargerThan(int maxLen) {
    if (maxLen < 0) {
      throw new IllegalArgumentException("maxLen cannot be negative");
    }
    StringList filteredRest = rest.filterLargerThan(maxLen);
    if (first.length() > maxLen) {
      return filteredRest;
    }
    return new ConsStringList(first, filteredRest);
  }

  @Override
  public boolean hasDuplicates() {
    return restContains(first, rest) || rest.hasDuplicates();
  }

  private boolean restContains(String target, StringList list) {
    if (list.isEmpty()) {
      return false;
    }
    if (!(list instanceof ConsStringList)) {
      throw new IllegalArgumentException("Unknown StringList implementation");
    }
    ConsStringList c = (ConsStringList) list;
    return Objects.equals(target, c.first) || restContains(target, c.rest);
  }

  @Override
  public StringList removeDuplicates() {
    StringList restWithoutFirst = removeAll(first, rest);
    return new ConsStringList(first, restWithoutFirst.removeDuplicates());
  }

  private StringList removeAll(String target, StringList list) {
    if (list.isEmpty()) {
      return list;
    }
    if (!(list instanceof ConsStringList)) {
      throw new IllegalArgumentException("Unknown StringList implementation");
    }
    ConsStringList c = (ConsStringList) list;
    StringList cleanedRest = removeAll(target, c.rest);
    if (Objects.equals(target, c.first)) {
      return cleanedRest; // 跳过当前节点
    }
    return new ConsStringList(c.first, cleanedRest);
  }
}

