import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 기타의 개수 (N <= 10)
        int M = sc.nextInt(); // 곡의 개수 (M <= 50)
        
        // 각 기타가 연주할 수 있는 곡들을 비트마스크 형태로 관리
        // (물론, M이 최대 50이므로 long 하나(64비트) 안에 다 들어가긴 하지만,
        //  M이 50이라면 int(32비트)로는 부족할 수 있으므로 long을 사용해야 합니다.)
        long[] guitarSongs = new long[N];
        
        // 기타 이름이 중복되지 않는다는 조건이 있으므로, 따로 이름 저장은 필요치 않으나
        // 문제 형식을 위해 이름도 읽기만 하고 사용하지 않음
        for(int i = 0; i < N; i++){
            String name = sc.next(); // 기타 이름
            String playInfo = sc.next(); // 'Y'/'N'으로 구성된 문자열
            
            long mask = 0L;
            for(int j = 0; j < M; j++){
                if(playInfo.charAt(j) == 'Y') {
                    // j번째 곡을 연주 가능
                    mask |= (1L << j);
                }
            }
            guitarSongs[i] = mask;
        }
        
        int maxSongsCount = 0;   // 연주할 수 있는 곡의 최대 개수
        int minGuitarsCount = N; // 그 최대 개수를 만족할 때 필요한 기타의 최소 개수
        
        // 부분 집합을 1부터 2^N-1까지 순회 (0은 공집합이므로 제외)
        int totalSubsets = (1 << N);
        for(int subset = 1; subset < totalSubsets; subset++){
            long combinedSongs = 0L;
            int usedGuitars = 0;
            
            // 부분 집합에 포함된 기타들을 이용해 곡 마스크를 합침(OR)
            for(int i = 0; i < N; i++){
                if((subset & (1 << i)) != 0){
                    combinedSongs |= guitarSongs[i];
                    usedGuitars++;
                }
            }
            
            // combinedSongs에서 연주 가능한 곡의 개수를 센다.
            int songCount = Long.bitCount(combinedSongs);
            
            // 최대 개수를 갱신해야 하는 경우
            if(songCount > maxSongsCount) {
                maxSongsCount = songCount;
                minGuitarsCount = usedGuitars;
            } 
            // 최대 개수와 같다면, 기타 개수가 더 적은 경우 갱신
            else if(songCount == maxSongsCount && usedGuitars < minGuitarsCount) {
                minGuitarsCount = usedGuitars;
            }
        }
        
        // 만약 연주할 수 있는 곡이 하나도 없다면(maxSongsCount == 0) -1 출력
        if(maxSongsCount == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minGuitarsCount);
        }
    }
}
