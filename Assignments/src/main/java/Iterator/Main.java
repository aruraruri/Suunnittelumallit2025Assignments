package Iterator;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press enter to keep generating fibonacci numbers, 'x' to stop");
        FibonacciSequence fib = new FibonacciSequence();

        while (true) {

            String input = sc.nextLine();
            System.out.print(fib.getCurrent());
            fib.iterator().next();

            if (Objects.equals(input, "x")) {
                return;
            }
        }
    }
}
