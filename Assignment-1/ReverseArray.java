//forward-backward two-pointer

public class ReverseArray {

    public boolean Vowel(char ch) {
        if(ch =='a' ||ch =='o' || ch == 'i'|| ch == 'u' || ch == 'e' || ch ==
         'y'||ch == 'A'|| ch=='O'|| ch == 'I' || ch == 'U'||ch=='E'|| ch=='Y') {
             return true;
         }

         return false;
    }
    public String reverse(String s) {
        
       int start = 0; 
       int end = s.length() -1;
       char[] str = s.toCharArray();
     

       while(start<end) {
          char begin =  str[start];
          char last = str[end];
          
         if(!Vowel(begin)) {
             start ++;
             continue;
         }

         if(!Vowel(last)) {
             end--;
             continue;
         }

         char temp = str[start];
         str[start] = str[end];
         str[end] = temp;

         start++;
         end--;

        
       }

        return String.copyValueOf(str);
    }

    public static void main(String[] args) {
        String s = "Care";

        ReverseArray r = new ReverseArray();
        System.out.println(r.reverse(s));
    }
}
