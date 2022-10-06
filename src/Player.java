import java.util.Scanner;

public class Player{
  Scanner sc = new Scanner(System.in);
  
  private String name;
  protected int score;
  protected Map map;

  public Player(int mapSize, String name){
    this.name = name;
    this.map = new Map(mapSize);
  }

  private Boolean setShipChecker(int x1, int y1, int x2, int y2 , String map[][]){
    Boolean temp = true;
    if(x1 == x2){
      int y3 = y1;
      int y4 = y2;
      if(y1 > y2){
        y3 = y2;
        y4 = y1;
      }
      for(int i=y3 ; i<=y4 ; i++){
        if(map[i][x1] != " "){
          temp = false;
        }
      }
    }
    else if(y1 == y2){
      int x3 = x1;
      int x4 = x2;
      if(x1 > x2){
        x3 = x2;
        x4 = x1;
      }
      for(int i=x3 ; i<=x4 ; i++){
        if(map[i][y1] != " "){
          temp = false;
        }
      }
    }
    return temp;
  }

  public void setShip(){
    // 2 size ship x3
    int twoShip = 0;
    
    while(twoShip != 3){
      printMap();
      System.out.println("Input for 3x Two Ship");
      System.out.print("Coordinates X1 [Number : 1-" + map.getSize() + "] : ");
      Character x1 = sc.next().charAt(0);
      System.out.print("Coordinates Y1 [Number : A-" +((char) (map.getSize()+64)) + "] : ");
      Character y1 = sc.next().charAt(0);
      System.out.print("Coordinates X2 [Number : 1-" + map.getSize() + "] : ");
      Character x2 = sc.next().charAt(0);
      System.out.print("Coordinates Y2 [Number : A-" + ((char) (map.getSize()+64)) + "] : ");
      Character y2 = sc.next().charAt(0);
      
      // Check must be not outofbound and not at the same place and x1 equal x2 or y1 equal y2
      if((int)x1-48>=1 && (int)x2-48>=1 && y1>= 'A' && y2>='A' && (int)x1-48<=map.getSize() && (int)x2-48<=map.getSize() && ((int)y1-64)<= map.getSize() && ((int)y2-64)<= map.getSize() && setShipChecker(x1-48, y1-64, x2-48, y2-64, map.getMap()) && (x1 == x2 || y1 == y2)){
        if(x1 == x2 && (y1 < y2 || y1 > y2)){
          map.shipSetter(x1-48, y1-64, x2-48, y2-64);
          twoShip++;
        }
        else if(y1 == y2 && (x1 < x2 || x1 > x2)){
          map.shipSetter(x1-48, y1-64, x2-48, y2-64);
          twoShip++;
        }
        else{
          System.out.println("Invalid input");
        }
      }
      else{
        System.out.println("Invalid input");
      }
    }
  }

  public void fireMissile(Map ownMap , Map enemy){
    // Check if the coordinates
    System.out.println("Input coordinate to fire :");
    Character x1;
    Character y1;
    while(true){
      System.out.print("Coordinates X1 [Number : 1-" + map.getSize() + "] : ");
      x1 = sc.next().charAt(0);
      System.out.print("Coordinates Y1 [Number : A-" + ((char) (map.getSize()+64)) + "] : ");
      y1 = sc.next().charAt(0);
      if((int)x1-48>=1 && (int)x1-48<=map.getSize() && y1>='A' && (y1-64)<=(char) (map.getSize()-64) )
        break;
    }
    if(enemy.getMap()[y1-64][x1-48] == "S"){
      System.out.println("You hit an enemy ship!");
      ownMap.getMap()[y1-64][x1-48] = "X";
      score++;
    }
    else{
      ownMap.getMap()[y1-64][x1-48] = ".";
      System.out.println("Not hit");
    }
    System.out.println("==========================");
    System.out.println("|       Enemy map        |");
    System.out.println("==========================");
    ownMap.print();
    System.out.println("==========================");
    System.out.println("Press enter to continue...");
    sc.nextLine();
    sc.nextLine();
  }

  // Getter setter
  // ====================================
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void printMap(){
    map.print();
  }

  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Map getMap() {
    return this.map;
  }

  public void setMap(Map map) {
    this.map = map;
  }

}
