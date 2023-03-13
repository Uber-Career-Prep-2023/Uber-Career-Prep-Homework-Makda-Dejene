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
    
    for(int i = 0; i < nums.length - 1; i++) { // iterate end time
        if(start[i + 1] > end[i]) { // when collapse appears
              result.add(new int[] {start[j], end[i]}); // record
              j = i + 1; // move previous start time 
        }    
   }
    
   result.add(new int[] {start[j], end[nums.length - 1]}); // add last one
   return result.toArray(new int[result.size()][]);
    
  }
}
