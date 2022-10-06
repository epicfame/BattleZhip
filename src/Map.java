public class Map {

  private String map[][];
  private int size;

  private void generateMap(int size){
    map[0][0] = " ";
    for(int i=1 ; i<size+1 ; i++){
      map[0][i] = Integer.toString(i);
    }

    char c = 'A';
    for(int i=1 ; i<size+1 ; i++){
      map[i][0] = Character.toString(c);
      c++;
    }

    for(int i=1 ; i< size+1; i++){
      for(int j=1 ; j<size+1 ; j++){
        map[i][j] = " ";
      }
    }
  }

  public void print(){
    for(int i=0 ; i<size+1 ; i++){
      for(int j=0 ; j<size+1 ; j++){
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }

  public Map(int size) {
    this.size = size;
    this.map = new String[size+1][size+1];
    generateMap(size);
  }

  public void shipSetter(int x1, int y1, int x2, int y2){
    if(x1 == x2){ // berarti vertikal
      int y3 = y1;
      int y4 = y2;
      if(y1 > y2){
        y3 = y2;
        y4 = y1;
      }
      for(int i=y3 ; i<=y4 ; i++){
        map[i][x1] = "S";
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
        map[y1][i] = "S";
      }
    }

  }

  // Getter Setter
  public String[][] getMap() {
		return this.map;
	}

	public void setMap(String map[][]) {
		this.map = map;
	}

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

}
