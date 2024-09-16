package edu.touro.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextStatistics {
    public static int wordCount (String text) {
        int returnVal = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i < text.length() - 1) {
                if (text.charAt(i) == ' ' && text.charAt(i + 1) != ' ') {
                    returnVal += 1;
                }
            }
        }

        return returnVal + 1;
    }
    public static int uniqueWordCount (String text) {
        Map<String, Integer> wordsDict = new HashMap<>();
        String word = "";
        int wordIdx = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += Character.toLowerCase(text.charAt(i));
            }
            if (i < text.length() - 1) {
                if (text.charAt(i) == ' ' && (text.charAt(i + 1) != ' ')) {
                    wordIdx += 1;
                    wordsDict.put(word, wordIdx);
                    word = "";
                }
            }
        }
        wordIdx += 1;
        return wordsDict.size();
    }
    public static Map<String, Integer> wordStats (String text) {
        Map<String, Integer> instanceWordMap = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += Character.toLowerCase(text.charAt(i));
            }
            if (i < text.length() - 1) {
                if (text.charAt(i) == ' ' && text.charAt(i + 1) != ' ') {
                    instanceWordMap.put(word, instanceWordMap.getOrDefault(word, 0) + 1);;
                    word = "";
                }
            }
        }
        instanceWordMap.put(word, instanceWordMap.getOrDefault(word, 0) + 1);;

        return instanceWordMap;
    }
    public static int letterCount (String text) {
        Map<Character, Integer> charsDict = new HashMap<>();
        int charIdx = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                charsDict.put(Character.toLowerCase(text.charAt(i)), charIdx);
                charIdx += 1;
            }
        }
        return charsDict.size();
    }
    public static Map<Character, Integer> letterStats (String text) {

        Map<Character, Integer> instanceCharMap = new HashMap<>();
        char charVal = ' ';
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                charVal = Character.toLowerCase(text.charAt(i));
            }
            instanceCharMap.put(charVal, instanceCharMap.getOrDefault(charVal, 0) + 1);
        }

        return instanceCharMap;
    }

    public static void main (String[] args) {
        String str = "Hello hello hello person how are you you you you";
        String testStr = "Hey you! Yes you! I called you!";
        Map<String, Integer> instanceWordMap = new HashMap<>();

        assertEquals(5, wordCount("Hello how are you doing?"));
        assertEquals(6, wordCount("Hello how are you doing today?"));

        assertEquals(6, uniqueWordCount("This is a really really good day day day day"));
        assertEquals(9, uniqueWordCount("Everything went well today because I finished the Sugya today."));

        assertEquals("{called=1, yes=1, i=1, hey=1, you=3}", wordStats("Hey you yes you I called you").toString());
        assertEquals("{world=2, hello=1}", wordStats("Hello world World").toString());

        assertEquals(15, letterCount("Once open a time there lived a person"));
        assertEquals(17, letterCount("computer science is about solving puzzles"));

        assertEquals(1, letterStats("I can't believe I ate the whole thing").toString());
        System.out.println(wordCount(str));
        System.out.println(uniqueWordCount(str));
        System.out.println(wordStats(str));
        System.out.println(letterCount(str));
        System.out.println(letterStats(str));
    }

}
