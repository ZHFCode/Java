package basic_class_05;

/**
 * Created by ZHF on 2018/8/23.
 */

//前缀树
/*
要把值放在边上，不能放在点上
 */
public class TrieTree {
    public static class TrieNode {
        private int path;
        private int end;
        private TrieNode[] next;

        public TrieNode() {
            path = 0;
            end = 0;
            next = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    node.next[index]=new TrieNode();
                }
                node = node.next[index];
                node.path++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            int index = 0;
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }

        public void delete(String word) {
            if (word != null) {
                int index = 0;
                char[] chars = word.toCharArray();
                TrieNode node = root;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.next[index].path == 0) {
                        node.next[index] = null;
                        return;
                    }
                    node = node.next[index];
                }
                node.end--;
            }
        }

    }

}
