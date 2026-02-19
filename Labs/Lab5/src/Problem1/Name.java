package Problem1;


public class Name {
  private final String first;
  private final String last;

  public Name(String first, String last) {
    if (first == null || last == null) throw new IllegalArgumentException("Name parts cannot be null");
    this.first = first;
    this.last = last;
  }

  public String getFirst() { return first; }
  public String getLast() { return last; }
}

