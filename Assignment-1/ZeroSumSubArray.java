// used hashmap
import java.util.HashSet;

public class ZeroSumSubArray {

	public static int countSubarrays( int[] arr) {
        HashSet<Integer> set = new HashSet();
        int sum = 0;
        int count = 0;

        for(int i = 0; i<arr.length; i++) {
            sum +=arr[i];

            if(arr[i]==0 || set.contains(sum)) {
                count++;
            }
            set.add(sum);
        }
        return count;
	}

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, -1, -3, -3, 4, 6, -7};
       
        ZeroSumSubArray s = new ZeroSumSubArray();
        System.out.println(s.countSubarrays(arr));
    }

}

// took 20 minutes
