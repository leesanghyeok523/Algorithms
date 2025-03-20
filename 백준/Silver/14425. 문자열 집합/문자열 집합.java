import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄에서 N, M을 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 집합 S를 저장할 HashSet
        HashSet<String> set = new HashSet<>();
        
        // 다음 N개의 줄에 걸쳐 집합 S에 포함되는 문자열을 입력받아 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        // M개의 문자열을 입력받으면서 집합 S 내 존재 여부 확인
        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                count++;
            }
        }
        
        // 집합 S에 포함된 문자열의 총 개수 출력
        System.out.println(count);
    }
}
