  /** Returns true if a level has a valid solution */
  public static boolean betterCheck(int[] level) {
    if (level[0] == 0 || level[level.length - 1] == 0) { // cannot start or end on a mine
      return false;
    }
    for (int i = 0; i < level.length; i++) {
      int nextMine = nextMine(i, level);

      if (nextMine < 0) { // no more mines
        return true;
      }

      int nextBoard = nextBoardAfterMine(nextMine, level);
      int jumpsToBoard = nextBoard - i;

      if (level[i] >= jumpsToBoard) { // jump over mine(s) to get to next board
        i = nextBoard - 1; // the for loop will add 1, so remove it here to compensate
        continue; // skip mine test
      }

      if (level[i] == 0) { // if on a mine, fail
        return false;
      }
    }

    return false;
  }

  /** Returns the index of the next mine in the level */
  private static int nextMine(int currentIndex, int[] level) {
    for (int i = currentIndex; i < level.length; i++) {
      if (level[i] == 0) {
        return i;
      }
    }
    return -1;
  }

  /** Returns the index of the next board after a mine in the level */
  private static int nextBoardAfterMine(int mineIndex, int[] level) {
    if (mineIndex < 0) { // if there are no more mines, return -1
      return -1;
    }
    for (int i = mineIndex; i < level.length; i++) {
      if (level[i] > 0) {
        return i;
      }
    }
    return -1;
  }