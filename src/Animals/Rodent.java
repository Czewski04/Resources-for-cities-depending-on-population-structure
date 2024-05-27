package Animals;

import Interfaces.Life;

public class Rodent extends Pet implements Life {
    private double seeds;

    public Rodent() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }

    public double Get_food_demand_for_pets(){
        return seeds;
    }

    public void change_meat_demand(double meat){

    }

    public void born(){

    }

    public void death(int age){

    }
}
