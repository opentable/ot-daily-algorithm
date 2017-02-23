package permutationsofstring;
import java.util.*;
/**
 * @author syip
 * Permutations of Given String
 * A permutation, also called an “arrangement number” or “order,” is a 
 * rearrangement of the elements of an ordered list S into a one-to-one 
 * correspondence with S itself. A string of length n has n! permutation.
 * Below are the permutations of string ABC. ABC ACB BAC BCA CBA CAB
 * 
 * Solution: Derive list based on solution of substring
 */
public class PermutationsOfString {
    public static Set<String> getPermutationsOfString (String str) {
        Set<String> results = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            results = permuteCharToStrings(results, str.charAt(i));
        }
        return results;
    }
    private static Set<String> permuteCharToStrings(Set<String> strList, Character ch) {
        Set<String> result = new HashSet<>();
        if (strList.isEmpty()) {
            result.add(String.valueOf(ch));
            return result;
        }
        for(String str : strList) {
            for (int i = 0; i < str.length()+1 ; i++){
                String newStr = str.substring(0,i) + ch + str.substring(i);
                if (!result.contains(newStr)) result.add(newStr);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> permutated = getPermutationsOfString("abb");
        assert permutated.equals(new HashSet<>(Arrays.asList("bba", "bab", "abb")));
        permutated = getPermutationsOfString("abc");
        assert permutated.equals(new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca", "cba", "cab")));
    }
}
