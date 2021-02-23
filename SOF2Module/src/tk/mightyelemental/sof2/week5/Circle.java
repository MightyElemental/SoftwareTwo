package tk.mightyelemental.sof2.week5;

public class Circle extends Shape {

    private double radius;

    public double getRadius() {
	return radius;
    }

    public void setRadius(double radius) {
	this.radius = radius;
    }

    public Circle() {
	this.radius = 1;
    }

    public Circle(double radius) {
	this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
	super(color, filled);
	this.radius = radius;
    }

    public double getArea() {
	return Math.PI * radius * radius;
    }

    public double getPerimeter() {
	return Math.PI * 2 * radius;
    }

    public String toString() {
	return String.format("A Circle with radius=%f, which is a subclass of %s", radius, super.toString());
    }

}
