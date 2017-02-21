import java.util.*;

public class ValidParentheses {

	private final String opening;
	private final String closing;

	public ValidParentheses(String opening, String closing) {
		assert opening != null && closing != null && opening.length() == closing.length();
		this.opening = opening;
		this.closing = closing;
	}

	public boolean isValid(String s) {
		if ( s == null || s.isEmpty() ) {
			return true;
		}

		// Keep opening parentheses type in a stack. Type is defined as the index in the configuration strings.
		final Deque<Integer> openIndexStack = new ArrayDeque<>();

		for( int i = 0; i < s.length(); ++i ) {
			final char c = s.charAt(i);
			int openingIndex = opening.indexOf(c);
			if ( openingIndex != -1 ) {
				openIndexStack.push(openingIndex);
			}
			else {
				final int closingIndex = closing.indexOf(c);
				if ( closingIndex == -1 ) {
					// Assuming only brackets are allowed.
					return false;
				}
				else {
					if ( openIndexStack.isEmpty() ) {
						// No opening paranthesis.
						return false;
					}
					else {
						openingIndex = openIndexStack.pop();
						if ( openingIndex != closingIndex ) {
							// Non-matching opening paranthesis.
							return false;
						}
					}
				}
			}
		}

		return openIndexStack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses validator = new ValidParentheses("({[", ")}]");

		assert validator.isValid("");
		assert validator.isValid("()");
		assert validator.isValid("()[]{}");
		assert !validator.isValid("(]");
		assert !validator.isValid("([)]");
	}
}
