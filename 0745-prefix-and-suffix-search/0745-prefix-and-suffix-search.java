class WordFilter {
    private Map<String, Integer> map = new HashMap<>();
    
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
          String word = words[i];
          int length = word.length();
          for (int j = 1; j <= length; j++) {
            for (int k = 1; k <= length; k++) {
              String key = word.substring(0, j) + "{" + word.substring(length - k);
              map.put(key, i);
            }
          }
        }
    }
    
    public int f(String pref, String suff) {
        String s = pref + "{" + suff;
        return map.getOrDefault(s, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */