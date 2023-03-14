//sort array then solve

public class MergeIntervals {
  public int[][] getMerge(int[][] nums) {
   if(nums == null || nums.length == 0){
            return new int[0][];
        }

   int[] start = new int[nums.length];
   int[] end = new int[nums.length];
    
   List<int[]> result = new LinkedList<>();
    
   for(int i = 0; i < nums.length; i++){
      start[i] = nums[i][0];
      end[i] = nums[i][1];
   }
		
	
    Arrays.sort(start);
    Arrays.sort(end);
		
    int j = 0; 
    
    for(int i = 0; i < nums.length - 1; i++) { 
        if(start[i + 1] > end[i]) {
              result.add(new int[] {start[j], end[i]}); 
              j = i + 1; 
        }    
   }
    
   result.add(new int[] {start[j], end[nums.length - 1]}); 
   return result.toArray(new int[result.size()][]);
    
  }
}

//took 30 minutes
