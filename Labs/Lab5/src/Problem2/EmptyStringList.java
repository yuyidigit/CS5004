package Problem2;


public class EmptyStringList implements StringList {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean contains(String s) {
    if (s == null) {
      throw new IllegalArgumentException("s cannot be null");
    }
    return false;
  }

  @Override
  public boolean containsAll(StringList other) {
    if (other == null) {
      throw new IllegalArgumentException("other cannot be null");
    }
    return other.isEmpty();
  }

  @Override
  public StringList filterLargerThan(int maxLen) {
    if (maxLen < 0) {
      throw new IllegalArgumentException("maxLen cannot be negative");
    }
    return this;
  }

  @Override
  public boolean hasDuplicates() {
    return false;
  }

  @Override
  public StringList removeDuplicates() {
    return this;
  }
}

