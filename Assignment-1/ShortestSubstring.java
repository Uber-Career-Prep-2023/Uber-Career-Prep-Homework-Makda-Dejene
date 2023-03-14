//variable size sliding window
public class ShortestSubstring {
    public String minimumWindow(String one, String two) {
        int[] map = new int[128];
        for (char c : two.toCharArray()) {
            map[c] += 1;
        }
        int begin = 0;
        int length = Integer.MAX_VALUE;
        int count = two.length();
        for (int left=0, right=0; right<one.length(); right++) {
            char c = one.charAt(right);
            map[c]--;
            if(map[c]>=0)  {
              count--; 
            }
            while (count == 0) {
                char d = one.charAt(left);
                map[d]++;
                if (map[d]>0) {
                    if (right-left+1<length) {
                        begin = left;
                        length = right-left+1;
                    }
                    count++;
                }
                left++;
            }
        }
        return length==Integer.MAX_VALUE?"":one.substring(begin, begin+length);
    }
  
}

\\took 35 minutes
