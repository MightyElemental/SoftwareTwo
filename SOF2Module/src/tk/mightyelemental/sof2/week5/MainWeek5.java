package tk.mightyelemental.sof2.week5;

public class MainWeek5 {

    public static void main(String[] args) {
	Shape s = new Shape();
	System.out.println(s);

	Circle c = new Circle();
	System.out.println(c);

	Rectangle r = new Rectangle();
	System.out.println(r);

	Point p1 = new Point(0, 0);
	Point p2 = new Point(4, 3);
	Line l = new Line(p1, p2);
	System.out.println(l);
    }

}
