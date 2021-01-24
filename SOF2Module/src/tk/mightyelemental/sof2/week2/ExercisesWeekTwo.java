package tk.mightyelemental.sof2.week2;

public class ExercisesWeekTwo {

    // Exercise 2
    public static void calcOrderCost(float bananas) {
	int total = (int) (bananas * 300);
	if (total > 5000)
	    total -= 150;
	total += 499;
	System.out.printf("%.1fkg of bananas costs $%.2f total\n", bananas, (total / 100.0));
    }

    // Exercise 3
    public static void trainingZone(int age, int rate) {
	float max = maxHeartRate(age);
	if (rate >= 0.9 * max) {
	    System.out.println("Interval training");
	} else if (rate >= 0.7 * max) {
	    System.out.println("Threshold training");
	} else if (rate >= 0.5 * max) {
	    System.out.println("Aerobic training");
	} else {
	    System.out.println("Couch potato");
	}
    }

    private static float maxHeartRate(int age) {
	return 208 - 0.7f * age;
    }

    // Exercise 4
    public static double triangleAreaHeron(double a, double b, double c) {
	double s = (a + b + c) / 2.0;
	return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Exercise 6
    public static void printNoSpace(String text) {
	System.out.println(text.replaceAll(" ", ""));
    }

    public static void printTitle(String text) {
	String[] words = text.split(" ");
	StringBuilder result = new StringBuilder();
	for (String word : words) {
	    word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	    result.append(word);
	    result.append(" ");
	}
	result.deleteCharAt(result.length() - 1);
	System.out.println(result.toString());
    }

    public static void printWordsNewLine(String text) {
	StringBuilder buffer = new StringBuilder();
	for (char c : text.toCharArray()) {
	    if (Character.isUpperCase(c)) {
		if (buffer.length() > 0) {
		    System.out.println(buffer.toString());
		    buffer.setLength(0);
		}
	    }
	    buffer.append(c);
	}
	System.out.println(buffer.toString());
    }

    // Exercise 7
    public static void compareNumbers(int num1, int num2) {
	String snum1 = String.valueOf(num1);
	String snum2 = String.valueOf(num2);
	StringBuilder result = new StringBuilder();

	for (int i = 0; i < snum1.length() && i < snum2.length(); i++) {
	    result.append(snum1.charAt(i) == snum2.charAt(i) ? 1 : 0);
	}
	int remaining = Math.max(snum1.length(), snum2.length()) - result.length();
	result.append("0".repeat(remaining));
	System.out.println(result.toString());
    }

    // Exercise 8
    public static void floydTriangle(int rowCount) {
	StringBuilder row = new StringBuilder();
	for (int i = 0; i < rowCount; i++) {
	    row.insert(0, i % 2 == 0 ? 1 : 0);
	    System.out.println(row.toString());
	}
    }

    public static void main(String[] args) {
	calcOrderCost(47.5f);

	trainingZone(20, 150);

	printTitle("HELLO WORLD");
	printWordsNewLine("HelloWorldThisIsJustSmashing");

	compareNumbers(1234667, 123565);

	floydTriangle(5);
    }

}
