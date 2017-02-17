package validparentheses;
import java.util.*;
/**
 * @author syip
 * Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 * 
 * Solution: Use a stack to maintain order of bracket ordering, push as open bracket
 * encountered, pop and compare when closed is encountered. O(N)
 */
public class ValidParentheses {
    public static boolean isStringValid(String inputString) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('[',']');
        brackets.put('{','}');
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            Character curChar = inputString.charAt(i);
            if (brackets.containsValue(curChar)) {
                if (bracketStack.isEmpty()) return false;
                if (!brackets.get(bracketStack.pop()).equals(curChar)) return false;
            }
            if (brackets.containsKey(curChar)) bracketStack.push(curChar);
        }
        return bracketStack.isEmpty();
    }
    public static void main(String[] args) {
        assert isStringValid("(34)(432)");
        assert isStringValid("(34()432)");
        assert isStringValid("(34({})432)");
        assert isStringValid("{(34()43[]2)}1");
        assert isStringValid("(()34()4[{}]32)21");        
        assert !isStringValid("(34(432)");
        assert !isStringValid("(34])(432)");
        assert !isStringValid("(34)](432)");
        assert !isStringValid("(34)[(]432)");
    }
}