public class Program3 {

  public static <T> void printArray(T[] anArray) {
    for (T element : anArray) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] intArr = {1, 2, 3, 4, 5};
    Double[] doubArr = {1.1, 2.2, 3.3, 4.4};
    Character[] charArr = {'H', 'E', 'L', 'L', 'O'};
    String[] strArr = {"once", "upon", "a", "time"};

    printArray(intArr);
    printArray(doubArr);
    printArray(charArr);
    printArray(strArr);
  }
}
