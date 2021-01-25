package tk.mightyelemental.sof2.week3;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {

    // Exercise 2
    public static String[] split(String text) {
	StringBuilder buffer = new StringBuilder();
	List<String> result = new ArrayList<String>();
	for (char c : text.toCharArray()) {
	    if (c == ' ') {
		if (buffer.length() > 0) {
		    result.add(buffer.toString());
		    buffer.setLength(0);
		}
	    } else {
		buffer.append(c);
	    }
	}
	result.add(buffer.toString());
	return result.toArray(String[]::new);
    }

    // Exercise 3
    public static String[] split(String text, String separators) {
	StringBuilder buffer = new StringBuilder();
	List<String> result = new ArrayList<String>();
	for (char c : text.toCharArray()) {
	    if (separators.indexOf(c) != -1) {
		if (buffer.length() > 0) {
		    result.add(buffer.toString());
		    buffer.setLength(0);
		}
	    } else {
		buffer.append(c);
	    }
	}
	result.add(buffer.toString());
	return result.toArray(String[]::new);
    }

}
