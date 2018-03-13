/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project01;

/**
 *
 * @author Skylor Criqui
 * @version 1
 */
public class Village {
    private int population;
    private int livestock;
    private int food;
    private int money;
    private double landValue;
    // Constructors
    public Village() {
        population = 0;
        livestock = 0;
        food = 0;
        money = 0;
        landValue = 0.0;
    }
    // Accessors and Mutators
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public int getLivestock() {
        return livestock;
    }
    public void setLivestock(int livestock) {
        this.livestock = livestock;
    }
    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        this.food = food;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public double getLandValue() {
        return landValue;
    }
    public void setLandValue(double landValue) {
        this.landValue = landValue;
    }
}
