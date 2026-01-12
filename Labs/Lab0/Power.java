/*
Three differences vs Python version:
1) Java is statically typed: we must declare a type (long), while Python is dynamically typed.
2) Java needs a class and a main method as the program entry point; Python can run top-level statements directly.
3) Python supports ** for exponentiation; Java does not, so I use bit shifting (or a loop/Math.pow).
*/

public class Power {
    public static void main(String[] args) {
        // 2^31 = 2147483648, which does NOT fit in int, so I use long.
        long result = 1L << 31;
        System.out.println(result);
    }
}
