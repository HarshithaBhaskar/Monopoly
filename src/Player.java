import java.util.ArrayList;
import java.util.List;

public class Player {

  String name;
  List<String> tilesOwned;
  int availableBalance;
  int row;
  int col;
  int housesOwned;

  public Player(String name) {
    this.name = name;
    this.tilesOwned = new ArrayList<>();
    this.availableBalance = 20000;
    this.housesOwned = 0;
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

  public void buyProperty(String tileName, int tilePrice){
    this.tilesOwned.add(tileName);
    this.availableBalance -= tilePrice;
  }

  public void buyHouse(int housePrice){
    this.availableBalance -= housePrice;
    this.housesOwned++;
  }

  public int getAvailableBalance() {
    return availableBalance;
  }

  public void setPosition(int row, int col){
    this.row = row;
    this.col = col;
  }



}
