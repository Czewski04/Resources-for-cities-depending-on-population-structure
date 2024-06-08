package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

public class Cat extends Pet implements Get_food_demand_for_pets, Set_food_demand_for_pets {
    private double meat;

    public Cat() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }

    public Cat(int age){
        this.age = age;
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }

    public double Get_food_demand_for_pets(){ return meat; }

    public void set_food_demand_for_pets(){
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }
}
