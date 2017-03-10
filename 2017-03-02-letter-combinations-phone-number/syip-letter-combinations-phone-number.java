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
    public static Set<String> getStringsFromNumbers(String num) {
        Set<String> results = new HashSet<>();
        for (int i = 0; i < num.length(); i++) {
            results = addCharToStrings(results, Integer.parseInt(num.charAt(i)+""));
        }
        return results;
    }
    private static Set<String> addCharToStrings(Set<String> strList, Integer val) {
        if (val < 2 || val > 9) return strList;
        Map<Integer, List<Character>> numToChar = new HashMap<>();
        numToChar.put(2,new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        numToChar.put(3,new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        numToChar.put(4,new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        numToChar.put(5,new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        numToChar.put(6,new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        numToChar.put(7,new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        numToChar.put(8,new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        numToChar.put(9,new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        Set<String> results = new HashSet<>();
        List<Character> charList = numToChar.get(val);
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
