class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
      int len = number.length() - k;
      int idx = 0;

      for (int i = 0; i < len; i++) {
        char max = '0';
        for (int j = idx; j <= k + i; j++) {
          char c = number.charAt(j);
          if (c > max) {
            max = c;
            idx = j + 1;
          }
        }
        sb.append(max);
      }
      return sb.toString();
    }
}