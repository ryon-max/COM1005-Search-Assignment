
public class RunRamblersBB {
  public static void main(String[] arg) {

    TerrainMap tm = new TerrainMap("tmc.pgm");
    tm.writeTMap("tmc.pgm");

    System.out.println(tm.getWidth());
    System.out.println(tm.getTmap()[7][2]);

  }
}
