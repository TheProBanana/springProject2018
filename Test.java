package project01;

/**
 *
 * @author Skylor Criqui
 */

public class Test {
    public static void main(String[] args){
        Map map1 = new Map(100,100);
        Map map2 = new Map(100, 100);
        System.out.println("Map One:");
        map1.mapConstructor();
        map1.getMap();
        System.out.println("Map Two:");
        map2.mapConstructor();
        map2.getMap();
    }
}
