import java.util.*;

public class WordBreakII {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<>());
    }
    
    private static List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        if (wordDict.contains(s)) {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                List<String> suffixList = wordBreakHelper(s.substring(i), wordDict, memo);
                for (String suffix : suffixList) {
                    result.add(prefix + " " + suffix);
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }

}
