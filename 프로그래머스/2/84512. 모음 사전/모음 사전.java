import java.util.*;

class Solution {
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    static String[] all =
        new String[(int) (5 + Math.pow(5, 2) + Math.pow(5, 3) + Math.pow(5, 4) + Math.pow(5, 5))];
    static int index = 0;
    
    public int solution(String word) {
        int answer = 0;
        
        
        for (int i = 1; i <= 5; i++) {
            dfs("", i, 0);
        }
        
        Arrays.sort(all);
        for (int i = 0; i < all.length; i++) {
            if (all[i].equals(word)) {
                answer = i + 1;
            }
        }
        
        
        return answer;
    }
    
    static void dfs(String word, int length, int depth) {
        if (depth == length) {
            all[index++] = word;
            return;
        }
        for (String a : alphabet) {
            dfs(word + a, length, depth + 1);
        }
    }
}