package tk.mightyelemental.sof2.week5;

import java.util.EmptyStackException;
import java.util.Stack;

public class SeminarThree {

    public static void main(String[] args) {
	System.out.println(verifyParenths("((())())()"));
	System.out.println(verifyParenths(")()("));
	System.out.println(verifyParenths("())"));
	System.out.println(verifyParenths("))"));
	System.out.println(verifyParenths("(("));
	System.out.println("");
	System.out.println(verifyParenthsStack("((())())()"));
	System.out.println(verifyParenthsStack(")()("));
	System.out.println(verifyParenthsStack("())"));
	System.out.println(verifyParenthsStack("))"));
	System.out.println(verifyParenthsStack("(("));
    }

    /**
     * @return -1 if the parentheses are balanced and properly nested. <br>
     *         OR index of offending parenthesis.
     */
    public static int verifyParenths(String input) {
	int result = -1;
	int openBrackets = 0;
	int lastOpenIndex = -1;
	for (int index = 0; index < input.length(); index++) {
	    if (input.charAt(index) == '(') {
		openBrackets++;
		lastOpenIndex = index;
	    } else if (openBrackets > 0)
		openBrackets--;
	    else
		return index;

	}
	if (openBrackets != 0)
	    result = lastOpenIndex;
	return result;
    }

    public static boolean verifyParenthsStack(String input) {
	Stack<Character> s = new Stack<Character>();
	for (int index = 0; index < input.length(); index++) {
	    if (input.charAt(index) == '(') {
		s.push('c');
	    } else {
		try {
		    s.pop();
		} catch (EmptyStackException e) {
		    return false;
		}
	    }
	}
	return s.empty();
    }

}
