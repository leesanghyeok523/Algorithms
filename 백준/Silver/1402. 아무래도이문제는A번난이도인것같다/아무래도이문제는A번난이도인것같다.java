import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();  // 테스트 케이스 수
        while(T-- > 0) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            
            // 문제의 논리에 따르면 언제나 변환 가능
            System.out.println("yes");
        }
        
        sc.close();
    }
}
