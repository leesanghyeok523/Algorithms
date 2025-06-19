import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            List<Integer> divisors = new ArrayList<>();
            int sumOfDivisors = 1; // 1 is always a divisor

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    sumOfDivisors += i;
                    if (i * i != n) { // If i*i == n, then i is the only divisor, don't add n/i
                        divisors.add(n / i);
                        sumOfDivisors += (n / i);
                    }
                }
            }

            Collections.sort(divisors); // Sort the divisors for output format

            if (sumOfDivisors == n) {
                sb.append(n).append(" = 1");
                for (int divisor : divisors) {
                    sb.append(" + ").append(divisor);
                }
                sb.append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}