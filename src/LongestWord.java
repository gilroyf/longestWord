import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
find longest word

given I = length of input
      D = size of dictionary
      L = average length of word in dictionary

      Complexity is 0(I + DL)
 */
public class LongestWord {
    public static String getLongestWord(String input, Set<String> dictionary) {
        Map<Character, Integer> inputFrequencyMap = createFrequencyCountMap(input);
        String longestWord = "";
        for (String dictEntry : dictionary) {
            if (canFormWord(dictEntry, inputFrequencyMap)) {
                if (dictEntry.length() > longestWord.length())
                    longestWord = dictEntry;
            }
        }
        return longestWord;
    }

    private static Map<Character, Integer> createFrequencyCountMap(String input) {
        return input.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1, Integer::sum
        ));
    }

    private static boolean canFormWord(String word, Map<Character, Integer> inputFrequencyMap) {
        Map<Character, Integer> wordFreqMap = createFrequencyCountMap(word);
        for (Map.Entry<Character, Integer> wordEntry: wordFreqMap.entrySet())
        {
            if (!inputFrequencyMap.containsKey(wordEntry.getKey()))
                return false;
            if (wordEntry.getValue()  > inputFrequencyMap.get(wordEntry.getKey()))
                return false;
        }
        return true;
    }
}
