import java.util.ArrayList;
import java.util.List;

class TrieNode {
    List<TrieNode> children;
    boolean validWord;

    public TrieNode() {
        children = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            children.add(null);
        }
        validWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children.get(index) == null) {
                current.children.set(index, new TrieNode());
            }
            current = current.children.get(index);
        }
        current.validWord = true;
    }

    public boolean isValidWord(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.validWord;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children.get(index) == null) {
                return null;
            }
            current = current.children.get(index);
        }
        return current;
    }

    public void remove(String word) {
        TrieNode node = searchNode(word);
        if (node != null) {
            node.validWord = false;
        }
    }
}

