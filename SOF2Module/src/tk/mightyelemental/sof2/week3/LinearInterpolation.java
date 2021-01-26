package tk.mightyelemental.sof2.week3;

public class LinearInterpolation {

    public static int[] resample(int[] datapoints, int scale) {
	int[] result = new int[scale * datapoints.length - scale + 1];
	int index = -1;
	for (int i = 0; i < datapoints.length; i++) {
	    result[++index] = datapoints[i];
	    if (i < datapoints.length - 1) {
		int[] interp = interpolate(datapoints[i], datapoints[i + 1], scale);
		for (int j = 0; j < interp.length; j++) {
		    result[++index] = interp[j];
		}
	    }
	}
	return result;
    }

    private static int[] interpolate(int a, int b, int scale) {
	double diff = b - a;
	double step = diff / scale;
	int[] result = new int[scale - 1];
	for (int i = 1; i <= result.length; i++) {
	    result[i - 1] = a + (int) Math.round(step * i);
	}
	return result;
    }

    public static int[][] resample(int[][] image) {
	int[][] result = new int[image.length * 2 - 1][image.length * 2 - 1];
	for (int i = 0; i < image.length; i++) {
	    for (int j = 0; j < image.length; j++) {
		result[i * 2][j * 2] = image[i][j];
		if (j < image.length - 1)
		    result[i * 2][j * 2 + 1] = (image[i][j] + image[i][j + 1]) / 2;
	    }

	}
	for (int i = 0; i < image.length - 1; i++) {
	    for (int j = 0; j < result.length; j++) {
		result[i * 2 + 1][j] = (result[i * 2][j] + result[i * 2 + 2][j]) / 2;
	    }
	}
	return result;
    }

}
