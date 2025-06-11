class Solution {
    public int solution(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String abplus = strA + strB;
        int a_b = Integer.parseInt(abplus);
        
        int ab2 = 2 * a * b;
        if (a_b >= ab2) {
            return a_b;
        } else {
            return ab2;
        }
    }
}