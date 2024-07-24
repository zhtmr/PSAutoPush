import java.io.*;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
         for (int i = 0; i < strings.length; i++) {
          for (int j = i + 1; j < strings.length; j++) {
            char c = strings[i].charAt(n);
            char c1 = strings[j].charAt(n);
            if (c > c1) {
              String tmp = strings[i];
              strings[i] = strings[j];
              strings[j] = tmp;
            } else if (c == c1) {
              if (strings[i].compareTo(strings[j]) > 0) {
                String tmp = strings[i];
                strings[i] = strings[j];
                strings[j] = tmp;
              }
            }
          }
        }
        
         return strings;
    }
}