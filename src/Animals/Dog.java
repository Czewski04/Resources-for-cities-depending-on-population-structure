package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

public class Dog extends Pet implements Get_food_demand_for_pets, Set_food_demand_for_pets {
    private double meat;

    public Dog() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }

    public Dog(int age){
        this.age = age;
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }

    public double Get_food_demand_for_pets(){
        return meat;
    }

    public void set_food_demand_for_pets(){
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }
}
