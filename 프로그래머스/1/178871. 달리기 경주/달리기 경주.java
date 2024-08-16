import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
          String player = players[i];
          map.put(player, i);
        }

        for (String call : callings) {
          Integer index = map.get(call);
          if (index == 0) continue;

          String prev = players[index - 1];
          players[index - 1] = call;
          players[index] = prev;

          map.put(call, index - 1);
          map.put(prev, index);
        }

        return players;
    }
}