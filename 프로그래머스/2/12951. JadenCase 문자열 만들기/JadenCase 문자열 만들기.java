

class Solution {
    public String solution(String s) {
        String lcString = s.toLowerCase();
        String[] split = lcString.split(" ", -1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
          String string = split[i];
          if (!string.isEmpty()) {
            String front = string.substring(0, 1).toUpperCase();
            result.append(front);
            result.append(split[i], 1, split[i].length());
          }
          if (i < split.length - 1) {
            result.append(" ");
          }
        }
        return result.toString();
    }
}