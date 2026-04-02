public class Program2 {

  public static void printArray(Integer[] anArray) {
    for (Integer element : anArray) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void printArray(Double[] anArray) {
    for (Double element : anArray) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void printArray(Character[] anArray) {
    for (Character element : anArray) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void printArray(String[] anArray) {
    for (String element : anArray) {
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
