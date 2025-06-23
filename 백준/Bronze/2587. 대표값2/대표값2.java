import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[5];
        int sum = 0;

        for(int i = 0; i < 5; i++) {
           numbers[i] = Integer.parseInt(br.readLine());
           sum += numbers[i];
        }

        Arrays.sort(numbers);

        int average = sum / 5;
        int median = numbers[2];

        System.out.println(average);
        System.out.println(median);

        br.close();
    }
}