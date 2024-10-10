import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int repeat = (N + 3)/ 4;
        for (int i = 1; i <= repeat; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}