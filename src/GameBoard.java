import java.awt.*;

import javax.swing.*;

public class GameBoard {

  JFrame gameBoard;

  GameBoard(){
    gameBoard = new JFrame();

    JButton button = new JButton("Start Game");
    button.setBounds(130, 100, 100, 40);

    JPanel place = new JPanel();
    place.setBounds(0, 0, 50, 50);
    place.setBackground(Color.WHITE);

    JLabel boston = new JLabel("Boston");
    JPanel bostonColor = new JPanel();
    bostonColor.setBackground(Color.BLUE);

    place.add(boston);
    place.add(bostonColor);
    place.setLayout(new GridLayout(2, 1));


    gameBoard.add(button);
    gameBoard.add(place);
    gameBoard.setSize(1000, 1000);
    gameBoard.setLayout(new BorderLayout());
    gameBoard.setVisible(true);
  }

//  private void gameCards(JFrame gameBoard){
//    JLabel placeNames = new JLabel();
//    placeNames.setText("Enter 32 Place names below");
//
//    JTextArea place1 = new JTextArea();
//    JTextArea place2 = new JTextArea();
//    JTextArea place3 = new JTextArea();
//    JTextArea place4 = new JTextArea();
//    JTextArea place5 = new JTextArea();
//    JTextArea place6 = new JTextArea();
//    JTextArea place7 = new JTextArea();
//    JTextArea place8 = new JTextArea();
//    JTextArea place9 = new JTextArea();
//    JTextArea place10 = new JTextArea();
//    JTextArea place11 = new JTextArea();
//    JTextArea place12 = new JTextArea();
//    JTextArea place13 = new JTextArea();
//    JTextArea place14 = new JTextArea();
//    JTextArea place15 = new JTextArea();
//    JTextArea place16 = new JTextArea();
//    JTextArea place17 = new JTextArea();
//    JTextArea place18 = new JTextArea();
//    JTextArea place19 = new JTextArea();
//    JTextArea place20 = new JTextArea();
//    JTextArea place21 = new JTextArea();
//    JTextArea place22 = new JTextArea();
//    JTextArea place23 = new JTextArea();
//    JTextArea place24 = new JTextArea();
//    JTextArea place25 = new JTextArea();
//    JTextArea place26 = new JTextArea();
//    JTextArea place27 = new JTextArea();
//    JTextArea place28 = new JTextArea();
//    JTextArea place29 = new JTextArea();
//    JTextArea place30 = new JTextArea();
//    JTextArea place31 = new JTextArea();
//    JTextArea place32 = new JTextArea();
//    JTextArea place33 = new JTextArea();
//    JTextArea place34 = new JTextArea();
//    JTextArea place35 = new JTextArea();
//    JTextArea place36 = new JTextArea();
//    JTextArea place37 = new JTextArea();
//    JTextArea place38 = new JTextArea();
//    JTextArea place39 = new JTextArea();
//    JTextArea place40 = new JTextArea();
//
//    gameBoard.add(placeNames);
//    gameBoard.add(place1);
//    gameBoard.add(place1);
//    gameBoard.add(place1);
//    gameBoard.add(place1);
//    gameBoard.add(place1);
//
//
//
//  }


  public static void main(String[] args){
    new GameBoard();
  }

}
