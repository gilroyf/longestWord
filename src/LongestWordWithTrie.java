import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;

public class LongestWordWithTrie {

    private static Node root = new Node();

    public static class Node {
        public Character value;
        public Node parent;
        public Map<Character, Node> children;
        public String longestWord="";
    }

    public static String getLongestWord(String input, Set<String> dictionary) {
        root.value = null;
        root.parent = null;
        root.children = new HashMap<>();
        populateTri(dictionary);

        final String sortedWord = sortWord(input);

        return findLongestWord(root, sortedWord, 0, "", "");
    }

    private static String findLongestWord(Node node, String input, int index, String longestWord, String wordSoFar) {
        if (node.longestWord.length() > longestWord.length())
            longestWord = node.longestWord;

        for (int i= index; i< input.length(); ++i)
        {
            Character key = Character.valueOf(input.charAt(i));
            if (node.children.containsKey(key))
            {
                wordSoFar += input.charAt(i);
                String lv = findLongestWord(node.children.get(key), input, index+1, longestWord, wordSoFar);
                if (lv.length() > longestWord.length())
                    longestWord = lv;
                wordSoFar = wordSoFar.substring(0, wordSoFar.length()-1);
            }
        }
        return longestWord;
    }

    private static void populateTri(Set<String> dictionary) {
        for (String word : dictionary) {
            final String sortedWord = sortWord(word);
            Node node = root;
            for (char c: sortedWord.toCharArray())
            {
                if (node.children.containsKey(c))
                    node = node.children.get(c);
                else {
                    Node item = new Node();
                    item.value = c;
                    item.parent = node;
                    item.children = new HashMap<>();
                    node.children.put(c, item);
                    node = node.children.get(c);
                }
            }
            node.longestWord = node.longestWord.length() > word.length() ? node.longestWord : word;
        }
    }

    private static String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
