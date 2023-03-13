public class KAnagrams {

    public boolean findKAnagarams(String one, String two, int k) {
      
    if (one == null || two == null || one.length() != two.length()) {
        return false;
    }
    
    int[] alpha = new int[26];
    for (int i = 0; i < one.length(); i++) {
        alpha[str1.charAt(i) - 'a']++;
        alpha[str2.charAt(i) - 'a']--;
    }
    
    int difference = 0;
      
    for (int count : alpha) {
        if (count != 0) {
            difference += Math.abs(count);
            if (difference > k) {
                return false;
            }
        }
    }
    
    return true;
  }

}
