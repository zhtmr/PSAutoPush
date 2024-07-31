import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();


        for (String command : operations) {
          if (command.contains("I")) {
            String num = command.split(" ")[1];
            map.put(Integer.valueOf(num), map.getOrDefault(Integer.valueOf(num), 0) + 1);
          } else if (command.equals("D 1")) {
            if (map.isEmpty()) {
              continue;
            }
            Integer max = map.lastKey();
            if (map.get(max) == 1) {
              map.remove(max);
            } else {
              map.put(max, map.get(max) - 1);
            }
          } else {
            if (map.isEmpty()) {
              continue;
            }
            Integer min = map.firstKey();
            if (map.get(min) == 1) {
              map.remove(min);
            } else {
              map.put(min, map.get(min) - 1);
            }
          }
        }


        int[] result = new int[2];
        if (map.isEmpty()) {
          result[0] = 0;
          result[1] = 0;
        } else {
          result[0] = map.lastKey();
          result[1] = map.firstKey();
        }
        return result;
    }
}