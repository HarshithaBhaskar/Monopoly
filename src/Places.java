import java.util.Random;

public enum Places {

  CHICAGO, HOUSTON, PHOENIX,
  PHILADELPHIA, DALLAS, AUSTIN,
  JACKSONVILLE, COLUMBUS, CHARLOTTE,
  INDIANAPOLIS, SEATTLE, DENVER,
  WASHINGTON, BOSTON, NASHVILLE,
  DETROIT, PORTLAND, MEMPHIS,
  LOUISVILLE, BALTIMORE, ALBURQUERQUE,
  TUCSON, FRESNO, SACRAMENTO,
  ATLANTA, OMAHA, RALEIGH,
  MIAMI, OAKLAND, TAMPA,
  TULSA, ARLINGTON, BAKERSIELD,
  CLEVELAND, HONOLULU, RIVERSIDE,
  IRVINE, TOLEDO, MADISON, MEDOFRD;

  public static Tile getRandomPlaceTile(){
    Random random = new Random();
    String place = values()[random.nextInt(values().length)].toString();

    return new Tile(place, 1000);
  }

}
