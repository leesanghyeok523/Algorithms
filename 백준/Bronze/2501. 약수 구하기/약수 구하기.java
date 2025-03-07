import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int count = 0;
        // 1부터 N까지 반복하며 N의 약수를 찾는다.
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                // 약수를 찾을 때마다 카운트를 올리고
                count++;
                // K번째로 작은 약수이면 바로 출력 후 종료
                if (count == K) {
                    System.out.println(i);
                    return;
                }
            }
        }
        
        // N의 약수가 K개 미만이라면 0 출력
        System.out.println(0);
    }
}
