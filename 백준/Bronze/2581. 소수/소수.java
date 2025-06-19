import java.util.Scanner;

public class Main {

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) { // 2보다 작은 수는 소수가 아님
            return false;
        }
        // 2부터 num의 제곱근까지 나누어 떨어지는지 확인
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) { // 나누어 떨어지면 소수가 아님
                return false;
            }
        }
        return true; // 위에 해당하지 않으면 소수
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 첫 번째 자연수 M 입력
        int N = sc.nextInt(); // 두 번째 자연수 N 입력
        sc.close();

        int sum = 0; // 소수들의 합
        int minPrime = -1; // 최솟값 소수 (초기값 -1)

        // M부터 N까지 반복하며 소수 찾기
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) { // 현재 숫자가 소수이면
                sum += i; // 합에 더함
                if (minPrime == -1) { // 아직 최솟값이 설정되지 않았으면 (처음 발견된 소수)
                    minPrime = i; // 현재 소수를 최솟값으로 설정
                }
            }
        }

        if (sum == 0) { // 소수가 하나도 없어서 합이 0이면
            System.out.println(-1); // -1 출력
        } else { // 소수가 존재하면
            System.out.println(sum); // 소수들의 합 출력
            System.out.println(minPrime); // 최솟값 소수 출력
        }
    }
}