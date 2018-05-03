/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceGame;

/**
 *
 * @author Allison Cross
 */
public class CreatePlanet{
    private final int radius = 1; //set defaults for no arg
    private String name = " ";
    private String  item1 = " ";
   
    
    public CreatePlanet() {}
    
    //public void setRadius(int radius) {
    //    this.radius = radius;
    //}
    public void setName(String name) { //set name of planet
        this.name = name;
    }
    public void setItem1(String item){ //set resource for planet
        this.item1 = item;
    }
  
    public int getRadius(){ //sets the radius of each plane to 1
        return radius;
    }
    public String getName(){  //return a string with plant name
        return name;
    }
    public String getItem1(){   //returns string with resource name
        return item1;
    }
}
