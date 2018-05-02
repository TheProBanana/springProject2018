/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceGame;

import java.util.ArrayList;

/**
 *
 * @author Allison Cross
 */
public class Planets extends CreatePlanet{
    
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>(); //creating list to hold planet names
        ArrayList<String> items = new ArrayList<>(); //creating a list to hold items that a planet may have
        
        //add names
        planets.add("Wahear"); //come up with names not in our solar system so not bound by certain
                            //aesthetic expectation
        planets.add("Poald");
        planets.add("Zerwad");
        planets.add("Ulaplea");
        planets.add("Opnagad");
        planets.add("Ezvit");
        
        //add items
        items.add("diamonds");
        items.add("carbon");
        items.add("water");
        items.add("gold");
        items.add("oxygen");
        items.add("helium");    
        items.add("mud");
        items.add("nuclear energy");
        items.add("silver");
        
        //return 3 random planet names
        String planet1 = randomPlanets(planets);
        String planet2 = randomPlanets(planets);
        String planet3 = randomPlanets(planets);
        
        //return 3 random items for each planet to possess
        String item1 = randomItems(items);
          
    }
    
  
    
    public static String randomPlanets(ArrayList planets) {
        int index = (-1 + (int)Math.random())*7;
        String planet = (String) planets.get(index);
        return planet;
    }
    
    public static String randomItems(ArrayList items) {
        int index = (-1 + (int)Math.random())*10;
        String item = (String) items.get(index);
        return item;
    }
    
}
