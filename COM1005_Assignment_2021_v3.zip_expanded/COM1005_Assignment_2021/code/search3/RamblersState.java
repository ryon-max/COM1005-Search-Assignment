/**
 *	State in a map search
 *	Version for A*
 *	changes indicated by //A*
 * Phil Green	2013 version
 * Heidi Christensen (heidi.christensen@sheffield.ac.uk) 2021 version
*/

import java.util.*;

public class RamblersState extends SearchState{

  //city for this state
  private String Current;

  //constructor
  //A* - has estRemCost now
  public RamblersState(String cname, int lc){
    Current=cname;
    localCost=lc;
  }
  //accessors
  public String getCurrentplace(){
    return Current;
  }


  // goalPredicate
  public boolean goalPredicate(Search searcher) {
	  RamblersSearch msearcher = (RamblersSearch) searcher;
    String tar=msearcher.getGoal(); // get target city
    return (Current.compareTo(tar)== 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
	  RamblersSearch msearcher = (RamblersSearch) searcher;
	  TerrainMap map = msearcher.getMap();
	  int[][] aa = map.getTmap();
    ArrayList<Coords> links = map.getLinks(Current);
    ArrayList<SearchState> succs = new ArrayList();

    // loop over the links from my city
    for (Coords l: links){
    	String scity;
      if (Current.compareTo(l.getCity1()) == 0) {
        scity = l.getCity2();
      }
      else {
        scity = l.getCity1();
      }
      succs.add(new RamblersState(scity,l.getCost(), map.estbetween(scity,msearcher.getGoal())));
    }
    return succs;
  }

  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState ms2= (RamblersState) s2;
    return (Current.compareTo(ms2.getCity())==0);
  }

  // toString
  public String toString () {
    return ("Map State: "+Current);
  }
}



