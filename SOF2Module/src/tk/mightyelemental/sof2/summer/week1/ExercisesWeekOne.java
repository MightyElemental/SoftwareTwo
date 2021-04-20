package tk.mightyelemental.sof2.summer.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExercisesWeekOne {

	public static void main(String[] args) {
//		List<Integer> l = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
//		System.out.println("initial " + l);
//
//		while ((l = nextPermutation(l)) != null)
//			System.out.println("next perm " + l);

		System.out.println(allPermutations(2));
	}

	/* ACTIVITY 1 - QUESTION 1 */

	public static List<Integer> nextPermutation(final List<Integer> sequence) {
		int seqI = descendingIndex(sequence);
		if (seqI == -1)
			return null;

		int seqJ = getIndexOfLargestValAboveIndex(sequence, seqI);

		Collections.swap(sequence, seqI - 1, seqJ);
		List<Integer> lastHalf = sequence.subList(seqI, sequence.size());
		Collections.reverse(lastHalf);

		List<Integer> next = new ArrayList<Integer>(sequence.size());
		next.addAll(sequence.subList(0, seqI));
		next.addAll(lastHalf);

		return next;
	}

	/**
	 * Get the index of the element before the sequence is descending from there on.
	 * 
	 * <pre>
	 * [7,8,9,6,5,4,3,2,1]
	 * would give index=2 because everything after 9 is descending.
	 * [1,2,3,4,5]
	 * would give index=4 because everything is ascending.
	 * [5,4,3,2,1]
	 * would give index=-1 because everything is descending.
	 * </pre>
	 * 
	 * @param sequence the sequence of integers
	 * @return The index of the element before descending section
	 */
	public static int descendingIndex(final List<Integer> sequence) {
		for (int i = sequence.size() - 1; i > 0; i--)
			if (sequence.get(i) > sequence.get(i - 1))
				return i;
		return -1;
	}

	/* Find the largest index j such that j>=i and sequence[j] > sequence[i-1]. */
	public static int getIndexOfLargestValAboveIndex(final List<Integer> sequence, int i) {
		int seqI = sequence.get(i - 1);
		for (int j = sequence.size() - 1; j >= i; j--)
			if (sequence.get(j) > seqI)
				return j;
		return i;
	}

	/* ACTIVITY 1 - QUESTION 2 */

	public static Set<List<Integer>> allPermutations(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		List<Integer> perm = IntStream.rangeClosed(0, n).boxed().collect(Collectors.toList());
		Set<List<Integer>> result = new LinkedHashSet<List<Integer>>();
		do
			result.add(new ArrayList<Integer>(perm));
		while ((perm = nextPermutation(perm)) != null);
		return result;
	}

	/*
	 * ACTIVITY 1 - QUESTION 3
	 * SEE TSP.java FROM SEMINAR
	 */

}
