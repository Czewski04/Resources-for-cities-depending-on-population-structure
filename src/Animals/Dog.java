package Animals;

import Interfaces.Life;

public class Dog extends Pet implements Life {
    private double meat;

    public Dog() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }

    public double Get_food_demand_for_pets(){
        return meat;
    }

    public void change_meat_demand(double meat){

    }

    public void born(){

    }

    public void death(int age){

    }
}
