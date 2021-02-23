package tk.mightyelemental.sof2.week5;

public class Square extends Rectangle {

    public Square(double size) {
	super(size, size);
    }

    public String toString() {
	return String.format("A Square with size=%f, which is a subclass of %s", getWidth(), super.toString());
    }

    public void setWidth(double width) {
	setWidth(width);
	setLength(width);
    }

    public void setLength(double length) {
	setWidth(length);
	setLength(length);
    }

}
