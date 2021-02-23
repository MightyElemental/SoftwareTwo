package tk.mightyelemental.sof2.week5;

public class Shape {

    private String color;
    private boolean filled;

    private Point location;
    private double rotation;

    public Point getLocation() {
	return location;
    }

    public void setLocation(Point location) {
	this.location = location;
    }

    public double getRotation() {
	return rotation;
    }

    public void setRotation(double rotation) {
	this.rotation = rotation;
    }

    public Shape() {
	color = "red";
	filled = true;
    }

    public Shape(String color, boolean filled) {
	this.color = color;
	this.filled = filled;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color.toLowerCase();
    }

    public boolean isFilled() {
	return filled;
    }

    public void setFilled(boolean filled) {
	this.filled = filled;
    }

    public String toString() {
	return String.format("A Shape with color of %s and is %sfilled", color, filled ? "" : "not ");
    }

}
