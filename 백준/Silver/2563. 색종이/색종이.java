import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean [][] papers = new boolean[100][100];
        for (int i = 1; i <= N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    papers[row][col] = true;
                }
            }
        }

        int blackArea = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++){
                if (papers[i][j]) {
                    blackArea++;
                }
            }
        }
        System.out.println(blackArea);
    }
}