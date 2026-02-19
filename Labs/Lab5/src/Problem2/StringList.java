package Problem2;


public interface StringList {
  boolean isEmpty();
  int size();
  boolean contains(String s);
  boolean containsAll(StringList other);
  StringList filterLargerThan(int maxLen);
  boolean hasDuplicates();
  StringList removeDuplicates();
}

