
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int a = 1000000;
        int b = -1000000;

        for (int i = 0; i < N; i++) {
            if (arr[i] < a) {
                a = arr[i];
            }
            if (arr[i] > b) {
                b = arr[i];
            }
        }
        System.out.println(a + " " + b);
    }
}
