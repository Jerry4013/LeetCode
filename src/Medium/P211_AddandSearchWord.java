package Medium;

import java.util.Stack;

public class P211_AddandSearchWord {

    private Trie root;

    /** Initialize your data structure here. */
    public P211_AddandSearchWord() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie curr = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] chars, int i, Trie node) {
        if (i == chars.length) {
            return node.isWord;
        }
        if (chars[i] == '.') {
            for (int j = 0; j < node.children.length; j++) {
                if (node.children[j] != null && dfs(chars, i + 1, node.children[j])) {
                    return true;
                }
            }
        } else {
            return node.children[chars[i] - 'a'] != null && dfs(chars, i + 1, node.children[chars[i] - 'a']);
        }
        return false;
    }

    static class Trie {
        public Trie[] children = new Trie[26];
        public boolean isWord;
    }
}
