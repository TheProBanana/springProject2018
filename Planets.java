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
        planets.add("Wahear"); //populate arrayList with possible planet names
        planets.add("Poald");
        planets.add("Zerwad");
        planets.add("Ulaplea");
        planets.add("Opnagad");
        planets.add("Ezvit");
        
        //add items
        items.add("diamonds");  //populate a separate arrayList with the names of a resource each planet might have
        items.add("carbon");
        items.add("water");
        items.add("gold");
        items.add("oxygen");
        items.add("helium");    
        items.add("mud");
        items.add("nuclear energy");
        items.add("silver");
        
        // to determine planet name
        String planet1 = randomPlanets(planets);
        
        //to get a random item for planet to possess
        String item1 = randomItems(items);
          
    }
    
  //these methods obtain a random number within the arrayList as an index, use the index to get the name/resource, and pass it back
    
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
