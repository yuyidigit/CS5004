public class Program4 {

  public static Comparable getMax(Comparable[] anArray) {
    Comparable max = anArray[0];

    for (int i = 1; i < anArray.length; i++) {
      if (anArray[i].compareTo(max) > 0) {
        max = anArray[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    Integer[] intArr = {1, 2, 3, 4, 5};
    Double[] doubArr = {1.1, 2.2, 3.3, 4.4};
    Character[] charArr = {'H', 'E', 'L', 'L', 'O'};
    String[] strArr = {"once", "upon", "a", "time"};

    System.out.println("Max Integer is: " + getMax(intArr));
    System.out.println("Max Double is: " + getMax(doubArr));
    System.out.println("Max Character is: " + getMax(charArr));
    System.out.println("Max String is: " + getMax(strArr));
  }
}
