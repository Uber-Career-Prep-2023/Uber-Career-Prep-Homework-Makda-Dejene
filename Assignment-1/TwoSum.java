// one-directional hashing
public class TwoSum {
  
  public getTwoSum(int[] nums, int k) {
     HashMap<Integer, Integer> map = new HashMap();
    
    
       int count = 0;

       for(int i = 0; i<nums.length; i++) {
           if(map.containsKey(k-nums[i])) {
               count += map.get(k-nums[i]);
           }

           if(map.containsKey(nums[i])) {
               map.put(nums[i], map.get(nums[i])+1);
           } else {
                map.put(nums[i], i);
           }  
       }
       return count;
  }
  
}

//took 15 minutes
