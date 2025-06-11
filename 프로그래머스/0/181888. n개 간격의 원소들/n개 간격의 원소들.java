class Solution {
    public int[] solution(int[] num_list, int n) {
        int resultSize = (num_list.length + n - 1) / n;
        int[] answer = new int[resultSize];
        
        for (int i = 0; i < resultSize; i++) {
            answer[i] = num_list[i * n];
        }
        
        return answer;      
    }
}