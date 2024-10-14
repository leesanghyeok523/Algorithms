
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] bucket = new int[N];
        for (int i = 0; i < N; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            int ball = sc.nextInt();

            for (int j = first-1; j <= last-1; j++) {
                bucket[j] = ball;
            }
        }
        for (int i : bucket) {
            System.out.print(i + " ");
        }
    }
}
