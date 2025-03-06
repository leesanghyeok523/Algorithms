import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        // 1) "dz=" 을 우선 변환
        word = word.replace("dz=", "*");

        // 2) 나머지 크로아티아 알파벳 치환
        String[] croatianLetters = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        for (String cl : croatianLetters) {
            word = word.replace(cl, "*");
        }

        // 3) 변환된 문자열의 길이 = 크로아티아 알파벳의 개수
        System.out.println(word.length());
    }
}
