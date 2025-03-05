import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 윗부분: i=1부터 N까지
        for(int i = 1; i <= N; i++){
            // 공백 출력: (N - i)
            for(int j = 0; j < N - i; j++){
                System.out.print(" ");
            }
            // 별 출력: (2*i - 1)
            for(int j = 0; j < (2*i - 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 아랫부분: i=N-1부터 1까지
        for(int i = N-1; i >= 1; i--){
            // 공백 출력: (N - i)
            for(int j = 0; j < N - i; j++){
                System.out.print(" ");
            }
            // 별 출력: (2*i - 1)
            for(int j = 0; j < (2*i - 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
