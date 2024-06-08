package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

public class Rodent extends Pet implements Set_food_demand_for_pets, Get_food_demand_for_pets {
    private double seeds;

    public Rodent() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }

    public Rodent(int age){
        this.age = age;
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }

    public double Get_food_demand_for_pets(){
        return seeds;
    }

    public void set_food_demand_for_pets(){
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }
}
