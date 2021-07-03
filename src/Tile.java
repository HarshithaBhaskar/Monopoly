import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

public class Tile {

  String name;
  List<Player> players;
  int purchasePrice;
  boolean isTraversable;

  // Edge Place Tile
  public Tile(String name, int purchasePrice) {
    this.name = name;
    this.purchasePrice = purchasePrice;
    this.players = new ArrayList<>();
    this.isTraversable = true;
  }

  // Empty Center Tile

  public Tile() {
    this.name = "EMPTY TILE";
    this.isTraversable = false;
    this.purchasePrice = 0;
    this.players = null;
  }

  public String getName() {
    return name;
  }

  public List<Player> getPlayers() {
    if (this.isTraversable) {
      return players;
    }
    System.out.println("This is a non-traversable tile.");
    return new ArrayList<>();
  }

  public int getPurchasePrice() {
    if (this.isTraversable) {
      return this.purchasePrice;
    }
    System.out.println("This is a non-traversable tile.");
    return 0;
  }

  public void addPlayerOnTile(Player player) {
    if (this.isTraversable) {
      this.players.add(player);
    }
  }

  public void removePlayerFromTile(Player player) {
    if (this.isTraversable) {
      System.out.println(player);
      System.out.println("----" + this.players);
      List<Player> tempPlayers = new ArrayList<>();

      for (Player p: this.players) {
        if (!p.name.equals(player.name)){
          tempPlayers.add(p);
//          this.players.remove(p);
        }
      }
      this.players = tempPlayers;


//      this.players.remove(player);
      System.out.println("++++" + this.players);
    }
  }

  public String render() {
    String renderedTile = "" +
            "+--------------------+" +
            "|                    |" +
            "|                    |" +
            "|                    |" +
            "|                    |" +
            "|                    |" +
            "+--------------------+" +
            ">>>" + this.name + "<<<" +
            "++++++++PLAYERS+++++++";

    if (this.players != null) {
      for (Player player : this.players) {
        renderedTile = renderedTile.concat(player.name);
        renderedTile = renderedTile.concat("*");
      }
    }

    return renderedTile;
  }
}
