import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LevelChecker {

  /** Returns true if a level has a valid solution */
  public static boolean check(int[] level) {
    if (level.length == 1 && level[0] > 0) { // exit
      return true;
    }
    if (level[0] == 0) { // mine
      return false;
    }
    int maxJump = Math.min(level[0], level.length - 1);
    for (int i = 1; i <= maxJump; i++) {
      if (check(Arrays.copyOfRange(level, i, level.length))) {
        return true;
      }
    }
    return false;
  }

  /** Returns the shortest valid path of jumps to complete a level */
  public static List<Integer> getJumps(int[] level) {
    List<Integer> jumps = getJumpsAux(level);
    if (jumps.contains(-1)) {
      jumps.remove(Integer.valueOf(-1));
    }
    return jumps;
  }

  private static List<Integer> getJumpsAux(int[] level) {
    if (level.length == 1 && level[0] > 0) { // exit
      // return array of -1 to distinguish it as the rest of the jumps are positive
      return new LinkedList<Integer>(Arrays.asList(-1));
    }
    if (level[0] == 0) { // mine
      // return empty list
      return List.of();
    }

    int maxJump = Math.min(level[0], level.length - 1);

    LinkedList<List<Integer>> allJumps = new LinkedList<List<Integer>>();
    for (int i = 1; i <= maxJump; i++) {
      // recursive call with sub-array
      List<Integer> jumps = getJumpsAux(Arrays.copyOfRange(level, i, level.length));
      if (!jumps.isEmpty()) { // ignore invalid paths
        jumps.add(0, i); // insert the jump to get to the path
        allJumps.add(jumps);
      }
    }
    // If there are valid paths, select the shortest one
    if (!allJumps.isEmpty()) {
      allJumps.sort((j1, j2) -> Integer.compare(j1.size(), j2.size()));
      return allJumps.pop();
    }
    return List.of();
  }

  public static boolean betterCheck(int[] level) {
    // Initialise the cache
    Map<List<Integer>, Boolean> mem = new HashMap<List<Integer>, Boolean>();
    // Call the auxiliary function and pass the memory
    return betterCheckAux(level, mem);
  }

  private static boolean betterCheckAux(int[] level, Map<List<Integer>, Boolean> mem) {
    if (level.length == 1 && level[0] > 0) { // exit
      mem.put(arrayToList(level), true);
      return true;
    }
    if (level[0] == 0) { // mine
      mem.put(arrayToList(level), false);
      return false;
    }
    int maxJump = Math.min(level[0], level.length - 1);
    for (int i = 1; i <= maxJump; i++) {

      int[] subLevel = Arrays.copyOfRange(level, i, level.length);

      // convert the array into a list so it can be used as a map key
      List<Integer> listLevel = arrayToList(subLevel);

      if (mem.containsKey(listLevel)) {
        if (mem.get(listLevel)) {
          return mem.get(listLevel); // if the path is true, we can return it
        } else {
          continue; // we know this path is false, so skip the calculation and move to the next jump
        }
      }
      // If the level has not been checked already, check it and save the result
      if (betterCheckAux(subLevel, mem)) {
        mem.put(listLevel, true);
        return true;
      } else {
        mem.put(listLevel, false);
      }
    }
    mem.put(arrayToList(level), false);
    return false;
  }

  public static List<Integer> arrayToList(int[] arr) {
    List<Integer> listLevel = new ArrayList<Integer>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      listLevel.add(arr[i]);
    }
    return listLevel;
  }

}
