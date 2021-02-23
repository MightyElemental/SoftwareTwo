package tk.mightyelemental.sof2.week5;

public class Line {

    private Point start, end;

    private String color = "black";

    public Point getStart() {
	return start;
    }

    public void setStart(Point start) {
	this.start = start;
    }

    public Point getEnd() {
	return end;
    }

    public void setEnd(Point end) {
	this.end = end;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public Line(Point p1, Point p2) {
	this.start = p1;
	this.end = p2;
    }

    public double getLength() {
	return Math.sqrt((end.x - start.x) * (end.x - start.x) + (end.y - start.y) * (end.y - start.y));
    }

    public String toString() {
	return String.format("%s line of length %.3f, and points start=[%s], end=[%s]", color, getLength(), start, end);
    }

}
