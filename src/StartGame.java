import java.util.Scanner;

public class StartGame {

  Scanner sc = new Scanner(System.in);

  public void clearScreen(){
    for(int i=0 ; i<50 ; i++){
      System.out.println();
    }
  }

  public void turnPrint(Map m , Player p){
    System.out.println("==========================");
    System.out.println("|        Your map        |");
    System.out.println("==========================");
    p.printMap();
    System.out.println("==========================");
    System.out.println();
    System.out.println("==========================");
    System.out.println("|       Enemy map        |");
    System.out.println("==========================");
    m.print();
    System.out.println("==========================");
    System.out.println();
    
  }

  public boolean checkWinner(Player p1, Player p2){
    if(p1.getScore() == 6 ){
      System.out.println("==========================");
      String exit = "Player 1 Win the game!";
      for(int i=0 ; i<exit.length() ; i++){
        System.out.print(exit.charAt(i));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
      System.out.println();
      System.out.println("==========================");
      System.out.println("Thank you " + p1.getName() + " and " + p2.getName() + " for playing the game!");
      return false;
    }
    if(p2.getScore() == 6){
      System.out.println("==========================");
      String exit = "Player 2 Win the game!";
      for(int i=0 ; i<exit.length() ; i++){
        System.out.print(exit.charAt(i));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
      System.out.println();
      System.out.println("==========================");
      System.out.println("Thank you " + p1.getName() + " and " + p2.getName() + " for playing the game!");
      return false;
    }
    return true;
  }

  // Ship Checker

  private void battle(Player p1, Player p2, int mapSize){
    clearScreen();
    System.out.println("===========================");
    System.out.println("| Player 1 set your ship! |");
    System.out.println("===========================");
    p1.setShip();
    clearScreen();
    System.out.println("===========================");
    System.out.println("| Player 2 set your ship! |");
    System.out.println("===========================");
    p2.setShip();
    Map m1 = new Map(mapSize); // for player 1
    Map m2 = new Map(mapSize); // for player 2
    // P1/P2 turn
    int turn=1;
    while(checkWinner(p1, p2)){
      clearScreen();
        System.out.println("==========================");
        System.out.println("|       GAME INFO        |");
        System.out.println("==========================");
        System.out.println("Turn : " + turn);
        System.out.println("Player 1 score : " + p1.getScore());
        System.out.println("Player 2 score : " + p2.getScore());
        System.out.println("==========================");
        System.out.println();
      if(turn%2 == 1){
        System.out.println("==========================");
        System.out.println("|     Player 1 turn!     |");
        System.out.println("==========================");
        turnPrint(m1, p1);
        p1.fireMissile(m1 , p2.getMap());
      }
      else{
        System.out.println("==========================");
        System.out.println("|     Player 2 turn!     |");
        System.out.println("==========================");
        turnPrint(m2, p2);
        p2.fireMissile(m2 , p1.getMap());
      }
      turn++;
    }
    System.out.print("Press enter to continue...");
    sc.nextLine();
  }
  
  public StartGame() {
    clearScreen();

    // Input map size between 7 and 9
    int mapSize;
    while(true){
      System.out.println("Input a map size");
      System.out.print(">> ");
      try {
        mapSize = sc.nextInt();
        sc.nextLine();
        if(mapSize>=7 && mapSize<=9)
          break;
        else
          System.out.println("Invalid number, must be between 7 and 9");
      } catch (Exception e) {
        System.out.println("Invalid input, must be a number");
        sc.nextLine();
      }
    }
    System.out.println("Map mapSize : " + mapSize);
    System.out.println("Press enter to continue...");
    sc.nextLine();

    // Player selection
    System.out.print("Input name for player 1 : ");
    String name1 = sc.nextLine();
    System.out.print("Press enter to continue...");
    sc.nextLine();

    System.out.print("Input name for player 2 : ");
    String name2 = sc.nextLine();
    System.out.print("Press enter to continue...");
    sc.nextLine();

    Player h1 = new Player(mapSize,name1);
    Player h2 = new Player(mapSize,name2);
    battle(h1,h2, mapSize);
    
  }
  
}
