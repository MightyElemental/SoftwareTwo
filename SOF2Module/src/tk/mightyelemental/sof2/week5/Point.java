package tk.mightyelemental.sof2.week5;

public class Point {

    public double x, y;

    private String color = "black";

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public String toString() {
	return String.format("%s point %.2f, %.2f", color, x, y);
    }

}
