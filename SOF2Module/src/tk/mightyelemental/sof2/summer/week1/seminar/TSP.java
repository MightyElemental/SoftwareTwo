package tk.mightyelemental.sof2.summer.week1.seminar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSP {

	public static void main(String[] args) {
		List<List<String>> perms = allPermutations(Arrays.asList("lettuce", "cheese", "ketchup", "patty", "pickle"));
		System.out.println(perms);
		System.out.println(perms.size());
	}

	public static <T> List<List<T>> allPermutations(final List<T> initial) {
		List<List<T>> permutations = new ArrayList<List<T>>();
		if (initial.size() == 0)
			permutations.add(initial);
		else
			for (int i = 0; i < initial.size(); i++) {
				List<T> subList = new ArrayList<T>(initial);
				T element = subList.remove(i);
				List<List<T>> subPerms = allPermutations(subList);
				subPerms.forEach(e -> e.add(0, element));
				permutations.addAll(subPerms);
			}
		return permutations;
	}

}
