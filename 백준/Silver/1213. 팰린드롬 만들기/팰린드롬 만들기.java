import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();

        // 알파벳 개수를 저장할 배열 (A~Z : 인덱스 0~25)
        int[] freq = new int[26];
        for (int i = 0; i < name.length(); i++) {
            freq[name.charAt(i) - 'A']++;
        }

        // 팰린드롬을 만들 수 있는지 판단 (홀수 개수를 가진 알파벳이 2개 이상이면 불가능)
        int oddCount = 0;
        int oddIndex = -1; // 홀수 개수를 가진 알파벳의 인덱스
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
            if (oddCount > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        // 팰린드롬의 앞부분(왼쪽 절반) 구성
        StringBuilder leftPart = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            // 홀수인 알파벳이 있으면 하나를 중간에 둘 것이므로 freq[i] - 1 만큼만 왼쪽에 활용
            // 짝수인 알파벳이면 그대로 /2 번만큼 사용
            for (int j = 0; j < freq[i] / 2; j++) {
                leftPart.append((char) (i + 'A'));
            }
        }

        // 가운데 문자(홀수 빈도 알파벳이 있다면)
        String middle = "";
        if (oddIndex != -1) {
            middle = String.valueOf((char) (oddIndex + 'A'));
        }

        // 오른쪽 절반은 왼쪽 절반을 뒤집어서 붙이기
        String rightPart = leftPart.reverse().toString();

        // 정답 출력 (왼쪽 + 가운데 + 오른쪽)
        // 주의: rightPart를 만들고 나면 leftPart가 이미 reverse된 상태이므로
        // 다시 한번 reverse()를 호출해서 leftPart를 원래 순서로 복구하면 좋습니다.
        leftPart.reverse(); // 다시 원상복구 (필수는 아니지만 필요 시 사용)
        System.out.println(leftPart.toString() + middle + rightPart);
    }
}
