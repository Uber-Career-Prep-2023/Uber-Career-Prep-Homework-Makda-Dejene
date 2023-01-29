public class BackspaceStringCompare {
  
  public boolean backspaceCompare(String a, String b) {
        StringBuilder replace_a = new StringBuilder();
        StringBuilder replace_b = new StringBuilder();

        for(int i = 0; i<a.length(); i++) {
            
            if(a.charAt(i)=='#' && replace_a.length() != 0) {
                replace_a.deleteCharAt(replace_a.length()-1);
            } else  {
                replace_a.append(a.charAt(i));
            }
        }

    
        for(int i = 0; i<b.length(); i++) {
             if(b.charAt(i)=='#' && replace_b.length() != 0) {
                replace_b.deleteCharAt(replace_b.length()-1);
            } else {
                replace_b.append(b.charAt(i));
            }
        }

        if(replace_a.toString().equals(replace_b.toString())) {
            return true;
        }

        return false;
    }
}
