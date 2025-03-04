import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();
        
        // 1. 대각선 번호 n 찾기
        //    n(n+1)/2 >= X 를 만족하는 최소의 n을 찾는다.
        int diagonal = 0;
        int sum = 0; // 1부터 diagonal까지의 합 n(n+1)/2
        while (sum < X) {
            diagonal++;
            sum = diagonal * (diagonal + 1) / 2;
        }
        
        // 2. 대각선에서 X가 몇 번째 위치인지 찾기
        //    대각선의 마지막 원소(= sum)로부터 몇 개 떨어져 있는지 확인
        int diff = sum - X;
        
        // 3. 대각선 번호가 홀수인지 짝수인지에 따라
        //    분자와 분모를 결정한다.
        int numerator;   // 분자
        int denominator; // 분모
        
        if (diagonal % 2 == 0) {
            // 대각선 번호가 짝수일 때: 위에서 아래로 이동
            // 예: (1/2) -> (2/1), (1/4) -> (2/3) -> (3/2) -> (4/1) ...
            numerator = diagonal - diff;
            denominator = diff + 1;
        } else {
            // 대각선 번호가 홀수일 때: 아래에서 위로 이동
            // 예: (1/1), (2/1) -> (1/2), (3/1) -> (2/2) -> (1/3) ...
            numerator = diff + 1;
            denominator = diagonal - diff;
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}
