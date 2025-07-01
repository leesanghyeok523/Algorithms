import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // The number of operations is directly proportional to n.
        // So, the highest-order term is n.
        System.out.println(n); 
        
        // The degree of the polynomial n^1 is 1.
        System.out.println(1);
        
        sc.close();
    }
}