import java.util.*;

public class RamblersSearch extends Search {

  private TerrainMap map; //map we're searching
  private Coords goal; //goal 

  public TerrainMap getMap(){
    return map;
  }
  public String getGoal(){
	  int x = goal.getx();
	  int y = goal.gety();
	  String Goal = y + "," + x;
    return Goal;
  }

  public RamblersSearch(TerrainMap m, Coords Goal){
    map=m;
    goal=Goal;
  }
}
