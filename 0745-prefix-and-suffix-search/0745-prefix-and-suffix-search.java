import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    int index;

    public TrieNode() {
        children = new HashMap<>();
        index = -1;
    }
}

class WordFilter {
    private TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();
            // 모든 prefix와 suffix 조합을 저장
            for (int j = 0; j <= len; j++) {
                String modifiedWord = word.substring(j) + "{" + word;
                insert(modifiedWord, i);
            }
        }
    }

    private void insert(String word, int index) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
            current.index = index; // 현재 노드에 가장 큰 인덱스 저장
        }
    }

    public int f(String prefix, String suffix) {
        String searchWord = suffix + "{" + prefix;
        TrieNode current = root;
        for (char ch : searchWord.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return -1;
            }
        }
        return current.index;
    }
}
