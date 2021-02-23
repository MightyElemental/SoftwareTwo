package tk.mightyelemental.sof2.week7;

import java.util.Arrays;

public class Vector {

	private double[] data;

	public Vector(int length) {
		data = new double[length];
	}

	public Vector(double[] data) {
		this.data = data;
	}

	public double get(int index) {
		if (index < 0 || index >= data.length) {
			throw new InvalidDimensionException();
		}
		return data[index];
	}

	public void set(int index, double value) {
		if (index < 0 || index >= data.length) {
			throw new InvalidDimensionException();
		}
		data[index] = value;
	}

	public Vector getUnitVec() {
		double l = getLength();
		double[] newVecData = new double[data.length];
		for (int i = 0; i < data.length; i++)
			newVecData[i] = data[i] / l;
		return new Vector(newVecData);
	}

	public double getLength() {
		double temp = 0;
		for (int i = 0; i < data.length; i++)
			temp += data[i] * data[i];
		return Math.sqrt(temp);
	}

	public Vector normalize() {
		double l = getLength();
		if (l != 0 && l != 1)
			for (int i = 0; i < data.length; i++)
				data[i] /= l;
		return this;
	}

	public String toString() {
		return String.format("{%s}", Arrays.toString(data));
	}

	public Vector sub(Vector v) throws IncompatibleDimensionException {
		if (v.data.length != data.length) {
			throw new IncompatibleDimensionException("Vector is not the same length!");
		}
		double[] newVecData = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			newVecData[i] = data[i] - v.data[i];
		}

		return new Vector(newVecData);
	}

	public Vector subSave(Vector v) throws IncompatibleDimensionException {
		data = sub(v).data;
		return this;
	}

	public Vector mul(Vector v) throws IncompatibleDimensionException {
		if (v.data.length != data.length) {
			throw new IncompatibleDimensionException("Vector is not the same length!");
		}
		double[] newVecData = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			newVecData[i] = data[i] * v.data[i];
		}

		return new Vector(newVecData);
	}

	public Vector mulSave(Vector v) throws IncompatibleDimensionException {
		data = mul(v).data;
		return this;
	}

	public Vector sum(Vector v) throws IncompatibleDimensionException {
		if (v.data.length != data.length) {
			throw new IncompatibleDimensionException("Vector is not the same length!");
		}
		double[] newVecData = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			newVecData[i] = data[i] + v.data[i];
		}
		return new Vector(newVecData);
	}

	public Vector sumSave(Vector v) throws IncompatibleDimensionException {
		data = sum(v).data;
		return this;
	}

	public Vector sum(double s) {
		double[] newVecData = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			newVecData[i] = data[i] + s;
		}
		return new Vector(newVecData);
	}

	public Vector sumSave(double s) {
		data = sum(s).data;
		return this;
	}

	public Vector mul(double s) {
		double[] newVecData = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			newVecData[i] = data[i] * s;
		}
		return new Vector(newVecData);
	}

	public Vector mulSave(double s) {
		data = mul(s).data;
		return this;
	}

	public double dot(Vector v) throws IncompatibleDimensionException {
		if (v.data.length != data.length) {
			throw new IncompatibleDimensionException("Vector is not the same length!");
		}
		double result = 0;
		for (int i = 0; i < data.length; i++) {
			result += data[i] * v.data[i];
		}
		return result;
	}

}
