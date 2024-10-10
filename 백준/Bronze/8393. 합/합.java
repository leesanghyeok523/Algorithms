import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        int n = scanner.nextInt();
        for (int i = n; i >= 1; i--) {
            ans += i;
        }
        System.out.println(ans);
    }
}