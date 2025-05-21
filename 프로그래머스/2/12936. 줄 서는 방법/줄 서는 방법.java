import java.util.*;

class Solution {
    public List<Integer> solution(int n, long k) {
        List<Integer> answer = new ArrayList();
        List<Integer> number = new ArrayList();
        
        
        for(int i = 1; i <= n; i++) {
            number.add(i);
        }
        
        k--;
        
        while(n > 0) {
            long f = factorial(n-1);
            int index = (int) (k / f);
            answer.add(number.remove(index));
            k %= f;
            n--;
        }
        
        return answer;
    }
    
     private long factorial(int n) {
        long result = 1L;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
}


