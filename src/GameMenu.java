import java.util.Scanner;

public class GameMenu {

  Scanner sc = new Scanner(System.in);

  private void printSpace(){
    for(int i=0 ; i<10 ; i++){
      System.out.println();
    }
  }

  private void printRules(){
    System.out.println("Rules");
    System.out.println("=====================");
    System.out.println("1. This game can be played by 1 or 2 people, if 1 person then the other player is a bot, if you choose 2 people then the players will take turns");
    System.out.println("2. Players will take turns to drop and guess the opponent's ship");
    System.out.println("3. The player who can guess the location of the enemy ship will win the game");
    System.out.println("Press enter to continue");
    sc.nextLine();
  }

  private void printMenu(){
    System.out.println("Welcome to BattleShip");
    System.out.println("=====================");
    System.out.println("1. Start");
    System.out.println("2. Rules");
    System.out.println("3. Exit");
  }

  public GameMenu(){
    
    while(true){
      printSpace();
      printMenu();
      int n;
      while(true){
        System.out.print(">> ");
        try {
          n = sc.nextInt();
          sc.nextLine();
          if(n>=1 && n<=3)
            break;
          else
            System.out.println("Invalid number, must be between 1 and 3");
        } catch (Exception e) {
          System.out.println("Invalid input, must be a number");
          sc.nextLine();
        }
      }
      if(n == 1){
        StartGame s = new StartGame();
      }
      else if(n == 2){
        printRules();
      }
      else if(n == 3){
        System.out.println("Thank you for playing");
        return;
      }
    }
    
  }

}
