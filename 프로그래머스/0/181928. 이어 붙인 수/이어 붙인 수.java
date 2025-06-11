class Solution {
    public int solution(int[] num_list) {
        StringBuilder oddNumbers = new StringBuilder();
        StringBuilder evenNumbers = new StringBuilder();
        
        for (int num : num_list) {
            if (num % 2 != 0) {
                oddNumbers.append(num);
            } else {
                evenNumbers.append(num);
            }
        }
        
        int sumOfOddNumbers = Integer.parseInt(oddNumbers.toString());
        int sumOfEvenNumbers = Integer.parseInt(evenNumbers.toString());
        
        return sumOfOddNumbers + sumOfEvenNumbers;
    } 
}