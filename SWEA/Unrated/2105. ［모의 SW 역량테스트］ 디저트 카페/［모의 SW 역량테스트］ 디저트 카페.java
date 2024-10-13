import java.util.*;

public class Solution {
    static int[] di = {1, 1, -1, -1};
    static int[] dj = {-1, 1, 1, -1};
    static int N, ans;
    static int[][] arr;
    static int si, sj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            ans = -1;
            for (si = 0; si < N - 2; si++) {
                for (sj = 1; sj < N - 1; sj++) {
                    dfs(0, si, sj, new HashSet<>());
                }
            }
            System.out.printf("#%d %d\n", test_case, ans);
        }
        sc.close();
    }

    static void dfs(int n, int ci, int cj, Set<Integer> v) {
        if (n > 3) { // 종료조건(무조건 종료해야 함)
            return;
        }
        if (n == 3 && si == ci && sj == cj) { // 정답처리 조건(시작지점 복귀)
            ans = Math.max(ans, v.size());
            return;
        }

        for (int k = n; k < Math.min(n + 2, di.length); k++) { // 수정: k 범위 제한
            int ni = ci + di[k];
            int nj = cj + dj[k];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !v.contains(arr[ni][nj])) {
                v.add(arr[ni][nj]);
                dfs(k, ni, nj, v);
                v.remove(arr[ni][nj]);
            }
        }
    }
}