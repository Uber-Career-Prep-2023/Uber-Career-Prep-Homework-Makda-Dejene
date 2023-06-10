import java.util.*;

public class FirstKBinaryNumbers {
    public static String[] getFirstKBinaryNumbers(int k) {
        if (k <= 0) {
            return new String[0];
        }

        String[] result = new String[k];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < k; i++) {
            String binary = queue.poll();
            result[i] = binary;

            String Binary1 = binary + "0";
            String Binary2 = binary + "1";
            queue.offer(Binary1);
            queue.offer(Binary2);
        }

        return result;
    }
  
 // took 20 minutes
