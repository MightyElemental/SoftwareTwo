package tk.mightyelemental.sof2.week8;

public class ExercisesWeek8 {

	public static void main(String[] args) {
		ArraySet<String> as = new ArraySet<String>(5);
		as.add("loop");
		as.add("map");
		as.add("hello");
		as.add("java");
		as.add("grade");
		as.add("implement");
		System.out.println(as);
		as.remove("hello");
		System.out.println(as);
		as.add("cat");
		System.out.println(as);
		as.remove("loop");
		System.out.println(as);
		as.clear();
		System.out.println(as);

		LinkedListSet<String> lls = new LinkedListSet<String>();
		lls.add("Something");
		lls.add("Another");
		lls.add("GRR");
		lls.add("Asdf");
		lls.add("Another");
		System.out.println(lls.toString());
		System.out.println(lls.size());
		lls.remove("GRR");
		lls.remove("Another");
		System.out.println(lls.toString());
		lls.clear();
		System.out.println(lls.toString());
		System.out.println(lls.size());
		lls.add("Something");
		System.out.println(lls.toString());
	}

}