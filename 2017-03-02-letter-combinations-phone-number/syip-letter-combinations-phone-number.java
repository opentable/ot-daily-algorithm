package lettercombinationsphonenumber;
import java.util.*;
/**
 * @author syip
 * # Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 1 - () 2 - (abc) 3 - (def) 4 - (ghi) 5 - (jkl) 6 - (mno) 7 - (pqrs) 8 - (tuv) 9 - (wxyz)
 * 
 * Solution: Derive list based on solution of substring
 */
public class LetterCombinationsPhoneNumber {
    private static Map<Integer, List<Character>> NUMBER_TO_CHAR_LIST = new HashMap<>();
    static {
        NUMBER_TO_CHAR_LIST.put(2,new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        NUMBER_TO_CHAR_LIST.put(3,new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        NUMBER_TO_CHAR_LIST.put(4,new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        NUMBER_TO_CHAR_LIST.put(5,new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        NUMBER_TO_CHAR_LIST.put(6,new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        NUMBER_TO_CHAR_LIST.put(7,new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        NUMBER_TO_CHAR_LIST.put(8,new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        NUMBER_TO_CHAR_LIST.put(9,new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }    
    public static Set<String> getStringsFromNumbers(String num) {
        Set<String> results = new HashSet<>();
        for (int i = 0; i < num.length(); i++) {
            results = addCharToStrings(results, Integer.parseInt(num.charAt(i)+""));
        }
        return results;
    }
    private static Set<String> addCharToStrings(Set<String> strList, Integer val) {
        if (!NUMBER_TO_CHAR_LIST.containsKey(val)) return strList;
        Set<String> results = new HashSet<>();
        List<Character> charList = NUMBER_TO_CHAR_LIST.get(val);
        for (Character ch : charList) {
            if (strList.isEmpty()) results.add(String.valueOf(ch));
            else {
                for(String str : strList) {
                    results.add(str + String.valueOf(ch));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        assert getStringsFromNumbers("123").equals(new HashSet<>(Arrays.asList("cd", "bd", "ce", "ad", "be",
                "cf", "ae", "bf", "af")));
        assert getStringsFromNumbers("10").equals(new HashSet<>());
        assert getStringsFromNumbers("12").equals(new HashSet<>(Arrays.asList("a", "b", "c")));
        assert getStringsFromNumbers("2").equals(new HashSet<>(Arrays.asList("a", "b", "c")));
    }
}
