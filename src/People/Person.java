package People;

import Interfaces.Set_food_demand_for_people;

abstract public class Person implements Set_food_demand_for_people {
    protected int age;
    protected double potatoes;
    protected double apples;
    protected double bread;
    protected double cucumbers;
    protected double tomatoes;
    protected double meat;
    protected double water;

    public int getAge() {
        return age;
    }

    public double getWater() {
        return water;
    }

    public double getTomatoes() {
        return tomatoes;
    }

    public double getPotatoes() {
        return potatoes;
    }

    public double getMeat() {
        return meat;
    }

    public double getCucumbers() {
        return cucumbers;
    }

    public double getBread() {
        return bread;
    }

    public double getApples() {
        return apples;
    }

    public void add_age(){
        this.age += 1;
    }
}
