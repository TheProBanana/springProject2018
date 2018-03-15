package project01;

import javax.swing.*;

/**
 *
 * @author Skylor Criqui
 */

public class Test extends JPanel {
    public static void main(String[] args){
    // Window framework
        JFrame frame = new JFrame("Space Game");
        frame.add(new Test());
        frame.setSize(1080, 720);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*Map map1 = new Map(100,100);
        Map map2 = new Map(100, 100);
        System.out.println("Map One:");
        map1.mapConstructor();
        map1.getMap();
        System.out.println("Map Two:");
        map2.mapConstructor();
        map2.getMap();*/
    }
}
