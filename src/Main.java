import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println ("Test 1 passed:" + LongestWord.getLongestWord("heelps", Set.of("helps", "peel", "heeel", "hef", "shleep")).equals("shleep"));

        System.out.println ("Test 2 passed:" +LongestWord.getLongestWord("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", Set.of(
                "paraminobenzoyldiaethylominoethanolumphydrochloricum",
                "supercalifragilisticexpialidocious",
                "antidisestablishmentarianism",
                "pneumonoultramicroscopicsilicovolcanoconiosis")).equals("antidisestablishmentarianism"));

        System.out.println ("Test 3 passed:" +LongestWord.getLongestWord("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzo", Set.of(
                "paraminobenzoyldiaethylominoethanolumphydrochloricum",
                "supercalifragilisticexpialidocious",
                "antidisestablishmentarianism",
                "pneumonoultramicroscopicsilicovolcanoconiosis")).equals("paraminobenzoyldiaethylominoethanolumphydrochloricum"));
    }
}
