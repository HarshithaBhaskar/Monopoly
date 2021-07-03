import java.util.ArrayList;
import java.util.List;

public class Player {

  String name;
  List<String> tilesOwned;
  int availableBalance;
  int xPos;
  int yPos;

  public Player(String name) {
    this.name = name;
    this.tilesOwned = new ArrayList<>();
  }

//  public void setAvailableBalance(int availableBalance) {
//    this.availableBalance = availableBalance;
//  }

//  public void buyTile(Tile tile){
//    this.tilesOwned.add(tile.name);
//    this.availableBalance -= tile.purchasePrice;
//  }

  public String getName() {
    return name;
  }

  public List<String> getTilesOwned() {
    return tilesOwned;
  }

  public int getAvailableBalance() {
    return availableBalance;
  }

    // TODO: Figure this out
  public void setPosition(int xPos, int yPos){
    this.xPos = xPos;
    this.yPos = yPos;
  }



}
