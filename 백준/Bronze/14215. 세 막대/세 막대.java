import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] lengths = new int[3];
        for (int i = 0; i < 3; i++) {
            lengths[i] = sc.nextInt();
        }

        Arrays.sort(lengths);

        int a = lengths[0];
        int b = lengths[1];
        int c = lengths[2];

        if (a + b > c) {
            System.out.println(a + b + c);
        } else {
            System.out.println(a + b + (a + b - 1));
        }

        sc.close();
    }
}