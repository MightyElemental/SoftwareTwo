package tk.mightyelemental.sof2.week3;

import java.util.Arrays;

public class ExercisesWeekThree {

    public static void main(String[] args) {
	System.out.println(toBase10("10001011"));

	System.out.println(Arrays.toString(TextUtils.split("Hello World, this is pretty mundane!")));
	System.out.println(Arrays.toString(TextUtils.split("Hello!World!This is a test,string", "! ,")));

	System.out.println(Arrays.deepToString(rasterise(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 2)));

	int[] interpolated = LinearInterpolation.resample(new int[] { 1, 5, 13, 21 }, 3);
	System.out.println(Arrays.toString(interpolated));
	System.out.println();

	int[][] image = { { 1, 50, 20, 20 }, { 100, 255, 150, 30 }, { 10, 255, 130, 210 }, { 10, 255, 130, 210 } };
	int[][] interpImage = LinearInterpolation.resample(image);
	for (int[] row : interpImage) {
	    System.out.println(Arrays.toString(row));
	}
    }

    // Exercise 1
    public static int toBase10(String binary) {
	int result = 0;
	for (int i = 0; i < binary.length(); i++) {
	    result += Math.pow(2, binary.length() - 1 - i) * (binary.charAt(i) == '1' ? 1 : 0);
	}
	return result;
    }

    // Exercise 4
    public static int[][] rasterise(int[] data, int width) {
	if (data.length % width != 0)
	    return null;
	int rows = data.length / width;
	int[][] result = new int[rows][width];
	for (int i = 0; i < width; i++) {
	    for (int j = 0; j < rows; j++) {
		result[j][i] = data[j * width + i];
	    }
	}
	return result;
    }

}
