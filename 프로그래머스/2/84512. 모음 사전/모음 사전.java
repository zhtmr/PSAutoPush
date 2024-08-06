import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] alphabet = {"A", "E", "I", "O", "U"};

        String[] all =
            new String[(int) (5 + Math.pow(5, 2) + Math.pow(5, 3) + Math.pow(5, 4) + Math.pow(5, 5))];

        int index = 0;

        for (int i = 0; i < 5; i++) {
          all[index++] = alphabet[i];
        }

        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            all[index++] = alphabet[i] + alphabet[j];
          }
        }

        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
              all[index++] = alphabet[i] + alphabet[j] + alphabet[k];
            }
          }
        }

        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
              for (int l = 0; l < 5; l++) {
                all[index++] = alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l];
              }
            }
          }
        }

        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
              for (int l = 0; l < 5; l++) {
                for (int m = 0; m < 5; m++) {
                  all[index++] = alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m];
                }
              }
            }
          }
        }
        
        Arrays.sort(all);
        for (int i = 0; i < all.length; i++) {
            if (all[i].equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}