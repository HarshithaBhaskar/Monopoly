import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManager {

  private List<String> playerNames;
//  private Map<String, List<String>> purchasedTiles;

  public GameManager(List<String> playerNames, int numberOfTurns) {
    this.playerNames = playerNames;
//    this.purchasedTiles = new HashMap<>();
    Tile[][] gameboard = this.makeGameboard();
    this.addPlayers(gameboard);
    this.playGame(numberOfTurns, gameboard);
  }

  private void playGame(int numberOfTurns, Tile[][] gameboard) {
    List<Player> players = new ArrayList<>();

    for (String playerName : this.playerNames) {
      players.add(new Player(playerName));
    }

    for (int i = 0; i < numberOfTurns; i++) {
      for (Player player : players) {
        int steps = this.rollDice();
        this.move(player, steps, gameboard);
      }

    }
  }

  private void addPlayers(Tile[][] gameboard) {
    List<Player> players = new ArrayList<>();

    for (String playerName : this.playerNames) {
      players.add(new Player(playerName));
    }

    for (Player player : players) {
      gameboard[0][0].addPlayerOnTile(player);
    }

  }

  private Tile[][] makeGameboard() {
    Tile[][] gameboard = new Tile[10][10];

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i == 0 || j == 0 || i == 9 || j == 9) {
          gameboard[i][j] = Places.getRandomPlaceTile();
        } else {
          gameboard[i][j] = new Tile();
        }
      }
    }

    return gameboard;
  }

  private int rollDice() {
    return 1 + (int) (Math.random() * ((6 - 1) + 1));
  }

  private void move(Player player, int steps, Tile[][] gameboard) {

    System.out.println("MOVE - " + player);
    int playerRow = player.row;
    int playerCol = player.col;

    gameboard[playerRow][playerCol].removePlayerFromTile(player);

    if (playerRow == 0 && playerCol < 9) {
      movePlayer(player, steps, 9, gameboard, "h");
    } else if (playerRow < 9 && playerCol == 0) {
      movePlayer(player, steps, 0, gameboard, "v");
    } else if (playerRow == 9) {
      movePlayer(player, steps, 0, gameboard, "h");
    } else if (playerCol == 9) {
      movePlayer(player, steps, 9, gameboard, "v");
    }
  }

  private void movePlayer(Player player, int steps, int moveBound, Tile[][] gameboard, String moveVector) {

    int playerRow = player.row;
    int playerCol = player.col;

    if (moveVector.equals("h")) {

      int currentSteps = Math.abs(moveBound - playerCol);

      if (steps <= currentSteps) {
        playerCol += steps;
        player.setPosition(playerRow, playerCol);
        gameboard[playerRow][playerCol].addPlayerOnTile(player);
        this.payRent(player, gameboard);
      } else {
        playerCol = moveBound;
        player.setPosition(playerRow, playerCol);
        this.move(player, steps - currentSteps, gameboard);
      }

    } else if (moveVector.equals("v")) {

      int currentSteps = Math.abs(moveBound - playerRow);

      if (steps <= currentSteps) {
        playerRow += steps;
        player.setPosition(playerRow, playerCol);
        gameboard[playerRow][playerCol].addPlayerOnTile(player);
        this.payRent(player, gameboard);
      } else {
        playerRow = moveBound;
        player.setPosition(playerRow, playerCol);
        this.move(player, steps - currentSteps, gameboard);
      }

    }

  }

  private void buyProperty(Player player, Tile[][] gameboard) {
//    List<String> ownedProperties = new ArrayList<>(this.purchasedTiles.values());
//    List<String> ownedProperties = this.purchasedTiles.values().stream().flatMap(List::stream).collect(Collectors.toList());
//    boolean isOwned = ownedProperties.contains(gameboard[player.row][player.col].name);
    Tile property = gameboard[player.row][player.col];
    boolean isOwned = property.ownedBy != null;

    if (!isOwned) {
//      List<String> property = new ArrayList<>();
//      property.add(gameboard[player.row][player.col].name);
//      this.purchasedTiles.put(player.name, property);
      player.buyProperty(gameboard[player.row][player.col].name, gameboard[player.row][player.col].purchasePrice);
      property.setOwner(player);
    } else {
      System.out.println("THIS PROPERTY IS OWNED. YOU CANNOT BUY IT");
    }
  }

  private void buyHouse(Player player, Tile[][] gameboard) {
//    List<String> propertiesPlayerOwns = this.purchasedTiles.get(player.name);
    Tile property = gameboard[player.row][player.col];
    boolean playerOwnsProperty = player.tilesOwned.contains(property.name);

    if (playerOwnsProperty) {
      Tile currentTile = gameboard[player.row][player.col];
//      player.buyProperty(currentTile.name, currentTile.housePrice);
      player.buyHouse(currentTile.housePrice);
      currentTile.updateRent(currentTile.housePrice, 0);
    } else {
      System.out.println("YOU DO NOT OWN THIS PROPERTY. YOU CANNOT BUY A HOUSE HERE");
    }
  }

  private String showGameboard(Tile[][] gameboard) {
    String board = "";
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        board = board.concat(gameboard[i][j].render());
      }
      board = board.concat("\n");
    }
    return board;
  }

  private void payRent(Player player, Tile[][] gameboard){
    int rentOwed = gameboard[player.row][player.col].rent;
    Player owner = gameboard[player.row][player.col].ownedBy;

    if (owner != null){
      player.availableBalance -= rentOwed;
      owner.availableBalance += rentOwed;
    }

  }

  public static void main(String[] args) {
    List<String> players = new ArrayList<>();
    players.add("Amber");
    players.add("Ashley");

    new GameManager(players, 4);
  }

}
