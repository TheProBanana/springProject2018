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
    private String item2= " ";
    
    public CreatePlanet() {}
    
    //public void setRadius(int radius) {
    //    this.radius = radius;
    //}
    public void setName(String name) {
        this.name = name;
    }
    public void setItem1(String item){
        this.item1 = item;
    }
    public void setItem2(String item){
        this.item2 = item;
    }
    public int getRadius(){
        return radius;
    }
    public String getName(){
        return name;
    }
    public String getItem1(){
        return item1;
    }
}
