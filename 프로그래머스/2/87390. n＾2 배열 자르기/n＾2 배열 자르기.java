import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
          long pos = left + i;
          int row = (int) (pos / n);
          int col = (int) (pos % n);
          result[i] = Math.max(row, col) + 1;
        }


        return result;
    
    }
}