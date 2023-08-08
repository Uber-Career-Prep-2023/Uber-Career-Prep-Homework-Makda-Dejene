import java.util.Arrays;

public class CatalanNumbers {
    public static long[] calculateCatalanNumbers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input should be a non-negative integer.");
        }
        
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        return catalan;
    }
