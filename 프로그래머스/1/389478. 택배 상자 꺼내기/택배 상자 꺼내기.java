class Solution {
 public int solution(int n, int w, int num) {
        // num의 0-based 인덱스
        int idx = num - 1;

        // 층수와 열 위치 계산
        int row = idx / w;
        int col;
        if (row % 2 == 0) {
            col = idx % w;
        } else {
            col = w - 1 - (idx % w);
        }

        int count = 0;

        // 위 층부터 검사
        for (int r = row + 1; r < (n + w - 1) / w; r++) {
            int base = r * w;
            int targetCol = (r % 2 == 0) ? col : (w - 1 - col);

            if (targetCol < w && base + targetCol < n) {
                count++;
            }
        }

        return count + 1;  // 자기 자신 포함
    }
}