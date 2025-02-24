import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();
        
        // 진법 변환 수행
        System.out.println(convertToBase(N, B));
    }

    public static String convertToBase(int N, int B) {
        StringBuilder result = new StringBuilder();
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        
        while (N > 0) {
            result.append(digits[N % B]);  // 해당 진법의 문자 추가
            N /= B;
        }
        
        return result.reverse().toString();  // 거꾸로 출력
    }
}
