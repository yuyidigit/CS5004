import java.util.Scanner;

public class AddFromKbd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int a = in.nextInt();

        System.out.print("Enter the second integer: ");
        int b = in.nextInt();

        System.out.println("Sum = " + (a + b));

        in.close();
    }
}
