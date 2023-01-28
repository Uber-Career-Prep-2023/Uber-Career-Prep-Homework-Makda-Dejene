// used fixed-sized sliding window
public class MaxMeanSubArray {
  
  public double SubArray(int[] nums, int k) {
    int start = 0;
    int end = start + (k-1);
    double mean = 0;
    double max = Integer.MIN_VALUE;
    
    while(end<nums.length) {
        for(int i = start; i<=end; i++) {
            mean+=nums[i];
        }
        
        mean/=(end-start+1);

        if(mean>max) {
          max = mean;
        }

        mean = 0;
        start++;
        end++;
    }
    
    return max;
    
  }

  public static void main(String[] args) {
      int[] nums = {1, 1, 1, 1, -1, -1, 2, -1, -1, 6};
        int k = 4;

        MaxMeanSubArray m = new MaxMeanSubArray();

        System.out.println(m.SubArray(nums, k));
  }
    
}

//took 25 minutes
