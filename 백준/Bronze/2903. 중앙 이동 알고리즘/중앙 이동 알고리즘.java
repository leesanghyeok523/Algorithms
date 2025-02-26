import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // (2^N + 1)^2 를 계산
        long side = (long) Math.pow(2, N) + 1;
        long result = side * side;

        System.out.println(result);
    }
}
