
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] bucket = new int[N];
        for (int i = 0; i < N; i++) {
            bucket[i] = i+1;
        }


        for (int i = 0; i < M; i++) {
            int temp;
            int first = sc.nextInt()-1;
            int next = sc.nextInt()-1;

            temp = bucket[first];
            bucket[first] = bucket[next];
            bucket[next] = temp;
        }
        for (int i : bucket) {
            System.out.print(i + " ");
        }
    }
}
