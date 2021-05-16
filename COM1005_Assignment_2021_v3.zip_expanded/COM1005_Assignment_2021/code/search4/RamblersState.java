import java.util.*;

public class RamblersState extends SearchState {

  // city for this state
  private String path;

  // constructor
  public RamblersState(String pname, int lc) {
    path = pname;
    localCost = lc;
  }

  // accessor
  public String getPath() {
    return path;
  }

  // goalPredicate
  public boolean goalPredicate(Search searcher) {
	RamblersSearch msearcher = (RamblersSearch) searcher;
    String tar = msearcher.getGoal(); // get target city
    return (path.compareTo(tar) == 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors(Search searcher) {
	  RamblersSearch msearcher = (RamblersSearch) searcher;
	  TerrainMap map = msearcher.getMap();
    ArrayList<Coords> links = map.getTmap();
    ArrayList<SearchState> succs = new ArrayList<SearchState>();

    for (Coords l : links) {
      String scity;
      if (path.compareTo(l.getx()) == 0) {
        scity = l.getCity2();
      } else {
        scity = l.getCity1();
      }
      ;
      succs.add((SearchState) new RamblersState(scity, l.getCost()));
    }
    return succs;
  }

  // sameState

  public boolean sameState(SearchState s2) {
    RamblersState ms2 = (RamblersState) s2;
    return (path.compareTo(ms2.getPath()) == 0);
  }

  // toString
  public String toString() {
    return ("Map State: " + city);
  }

}
