package project01;

/**
 *
 * @author Skylor Criqui
 */

public class Map {
    // Variables
    private char[][] map;
    private int x;
    private int y;
    // Constructors
    public Map(){
        this.x = 5;
        this.y = 5;
    }
    public Map(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void mapConstructor(){
        map = new char[x][y];
        for(int k = 0; k < this.y; k++){
            for(int i = 0; i < this.x; i++){
                int c = (int)(Math.random() * this.x - 1);
                int r = (int)(Math.random() * this.y - 1);
                if(k == r && i == c)
                    map[i][k] = 'T';
                else
                    map[i][k] = '~';
            }
        }
    }
    // Accessors and Mutators
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void getMap(){
        for(int k = 0; k < this.y; k++){
            for(int i = 0; i < this.x; i++){
                System.out.print(map[i][k] + " ");
                if(i == (this.x - 1))
                    System.out.printf("%n");
            }
        }
    }
    
}
