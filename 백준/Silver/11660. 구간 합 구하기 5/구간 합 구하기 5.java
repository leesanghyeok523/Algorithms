import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader, StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 표의 크기, M: 질의(쿼리) 횟수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 표(2차원 배열) 입력 받기
        int[][] arr = new int[N + 1][N + 1];  // 1-based index로 관리 (계산 편리)

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 누적 합 배열(prefix) 계산
        int[][] prefix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix[i][j] = prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1] 
                             + arr[i][j];
            }
        }

        // M번의 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 구간 합 계산
            int result = prefix[x2][y2]
                       - prefix[x2][y1 - 1]
                       - prefix[x1 - 1][y2]
                       + prefix[x1 - 1][y1 - 1];

            sb.append(result).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }
}
