import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int N = scanner.nextInt();
        int correct = 0;
        for (int i = 1; i <= N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            correct += a * b;
        }
        if (X == correct) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}