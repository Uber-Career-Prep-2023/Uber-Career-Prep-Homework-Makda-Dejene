public class MissingInteger{

  public int missingNumber(int[] nums) {
    int sum = (nums.length + 1) * nums.length / 2;
    for (int i : nums) {
      sum -= i;
    }
    return sum;

  }
}

//took 10 minutes
