import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameManager {

  private List<String> playerNames;

  public GameManager(List<String> playerNames, int numberOfTurns) {
    this.playerNames = playerNames;
    Tile[][] gameboard = this.makeGameboard();
    this.addPlayers(gameboard);
//    System.out.println(this.showGameboard(gameboard));
    this.playGame(numberOfTurns, gameboard);
    System.out.println(this.showGameboard(gameboard));
  }

  private void playGame(int numberOfTurns, Tile[][] gameboard){
    List<Player> players = new ArrayList<>();

    for (String playerName : this.playerNames) {
      players.add(new Player(playerName));
    }

    for (int i = 0; i < numberOfTurns; i++){
      for (Player player: players) {
        int steps = this.rollDice();
//        System.out.println(steps);
        this.move(player, steps, gameboard);
//        System.out.println(player.name + " = " + player.xPos + " | " + player.yPos);
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

    gameboard[player.xPos][player.yPos].removePlayerFromTile(player);

    if (player.xPos == 0 && player.yPos == 0) {
//      movePlayer(player, 9, steps, "h");
      int currentSteps = 9 - player.yPos;

      if (steps <= currentSteps){
        player.yPos += steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.yPos = 9;
        this.move(player, steps - currentSteps, gameboard);
      }
    } else if (player.xPos == 0 && player.yPos == 9) {
//      movePlayer(player, 9, steps, "v");

      int currentSteps = Math.abs(9 - player.xPos);

      if (steps <= currentSteps){
        player.xPos += steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.xPos = 9;
        this.move(player, steps - currentSteps, gameboard);
      }
    } else if (player.xPos == 9 && player.yPos == 0) {
//      movePlayer(player, 0, steps, "v");

      int currentSteps = Math.abs(0 - player.xPos);

      if (steps <= currentSteps){
        player.xPos -= steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.xPos = 0;
        this.move(player, steps - currentSteps, gameboard);
      }
    } else if (player.xPos == 9 && player.yPos == 9) {
//      movePlayer(player, 0, steps, "h");
      int currentSteps = Math.abs(0 - player.yPos);

      if (steps <= currentSteps){
        player.yPos -= steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.yPos = 0;
        this.move(player, steps - currentSteps, gameboard);
      }
    } else if (player.xPos == 0) {

//      movePlayer(player, 9, steps, "h");

      int currentSteps = 9 - player.yPos;

      if (steps <= currentSteps){
        player.yPos += steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.yPos = 9;
        this.move(player, steps - currentSteps, gameboard);
      }

      // Move direction right +y
    } else if (player.xPos == 9) {

//      movePlayer(player, 0, steps, "h");

      int currentSteps = Math.abs(0 - player.yPos);

      if (steps <= currentSteps){
        player.yPos -= steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.yPos = 0;
        this.move(player, steps - currentSteps, gameboard);
      }

      // Move direction left -y
    } else if (player.yPos == 0) {

//      movePlayer(player, 0, steps, "v");

      int currentSteps = Math.abs(0 - player.xPos);

      if (steps <= currentSteps){
        player.xPos -= steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.xPos = 0;
        this.move(player, steps - currentSteps, gameboard);
      }

      // Move direction up -x
    } else if (player.yPos == 9) {

//      movePlayer(player, 9, steps, "v");

      int currentSteps = Math.abs(9 - player.xPos);

      if (steps <= currentSteps){
        player.xPos += steps;
        gameboard[player.xPos][player.yPos].addPlayerOnTile(player);
      } else {
        player.xPos = 9;
        this.move(player, steps - currentSteps, gameboard);
      }

      // Move direction down +x
    }
  }

//  private void movePlayer(Player player, int moveDirectionBound, int steps, String direction) {
//    int vector = 0;
//
//    if (direction.equals("h")){
//      vector = player.yPos;
//    } else {
//      vector = player.xPos;
//    }
//
//    System.out.println(player.name + player.xPos + player.yPos);
//    System.out.println(vector);
//    int currentSteps = Math.abs(moveDirectionBound - vector);
//    System.out.println(currentSteps);
//    int changeInSteps;
//
//    if (moveDirectionBound == 0) {
//      changeInSteps = 0 - steps;
//    } else {
//      changeInSteps = steps;
//    }
//
//    System.out.println(changeInSteps);
//
//    if (steps <= currentSteps) {
//      vector += changeInSteps;
//      System.out.println("VECTOR = " + vector);
//    } else {
//      vector = moveDirectionBound;
//      System.out.println("VECTOR = " + vector);
//      this.move(player, steps - currentSteps);
//    }
//    System.out.println(player.name + "//" + player.xPos + "//" + player.yPos);
//  }

  private String showGameboard(Tile[][] gameboard){
    String board = "";
    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
//        System.out.println(i);
//        System.out.println(j);
        board = board.concat(gameboard[i][j].render());
      }
      board = board.concat("\n");
    }
    return board;
  }

  public static void main(String[] args){
    List<String> players = new ArrayList<>();
    players.add("Amber");
    players.add("Ashley");

    new GameManager(players, 1);
  }

}
