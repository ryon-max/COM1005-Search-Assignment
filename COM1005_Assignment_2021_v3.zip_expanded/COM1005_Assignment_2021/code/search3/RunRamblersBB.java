import java.io.File;

public class RunRamblersBB {
  public static void main(String[] arg) {

    TerrainMap tm = new TerrainMap("./COM1005_Assignment_2021/code/search3/tmc.pgm");
    System.out.println(new File(".").getAbsoluteFile());

    System.out.println(tm.getWidth());
    System.out.println(tm.getTmap()[7][2]);
    
    Coords Goal = new Coords(9,8);
    RamblersSearch searcher = new RamblersSearch(tm, Goal);
    SearchState initState = (SearchState) new RamblersState("Start", 0);
    
    String res_bb = searcher.runSearch(initState, "branchAndBound");
    System.out.println(res_bb);
  }
}
