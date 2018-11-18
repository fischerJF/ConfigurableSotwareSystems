package smashed_varexj;

import java.util.LinkedList;


// Class to wrap global variables

public class GlobalVarsWrapper {
  /* @(BFS) */
  public static LinkedList Queue;

  static {
    if (Configuration.BFS) {
      Queue = new LinkedList();
    }
  }
}
