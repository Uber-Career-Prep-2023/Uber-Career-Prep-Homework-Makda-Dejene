public class ShortestSubstring {
    public String minimumWindow(String one, String two) {
        int[] map = new int[128];
        for (char c : two.toCharArray()) {
            map[c] += 1;
        }
        int begin = 0;
        int len = Integer.MAX_VALUE;
        int count = two.length();
        for (int left=0, right=0; right<one.length(); right++) {
            char c = one.charAt(right);
            map[c]--;
            if(map[c]>=0)  {
              count--; 
            }
            while (count == 0) {
                char lc = one.charAt(left);
                map[lc]++;
                if (map[lc]>0) {
                    if (right-left+1<len) {
                        begin = left;
                        len = right-left+1;
                    }
                    count++;
                }
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":one.substring(begin, begin+len);
    }
  
}
