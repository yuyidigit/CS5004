public class Program1 {

  public static void printArray(Object[] anArray) {
    for (Object element : anArray) {
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
