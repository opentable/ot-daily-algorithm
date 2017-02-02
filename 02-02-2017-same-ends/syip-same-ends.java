package sameends;

/**
 * @author syip
 * Given a string, return the longest substring that appears at both the 
 * beginning and end of the string without overlapping. 
 * For example, sameEnds("abXab") is "ab".
 * sameEnds("abXYab") → "ab"
 * sameEnds("xx") → "x"
 * sameEnds("xxx") → "x"
 * 
 * Solution: Start at the middle, find longest matching substring
 */
public class SameEnds {
    public static String sameEnds (String string) {
        int midpoint = string.length()/2;
        int length = string.length();
        for (int i = midpoint; i > 0; i--) {
            if (string.charAt(i-1) == string.charAt(length-1)) {
                String front = string.substring(0, i);
                String tail = string.substring(length-i, length);
                if (front.equals(tail)) return front;
            }
        }
        return "";
    }
    public static void main(String[] args) {
        System.out.println(sameEnds("abxyab"));
        System.out.println(sameEnds("x"));
        System.out.println(sameEnds("xx"));
        System.out.println(sameEnds("abxyabbb"));
    }
}
