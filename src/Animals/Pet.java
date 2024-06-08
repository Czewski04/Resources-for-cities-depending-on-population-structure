package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

public abstract class Pet implements Get_food_demand_for_pets, Set_food_demand_for_pets {
    protected int age;
    protected double water;

    public int getAge() {
        return age;
    }

    public double getWater() {
        return water;
    }

    public void add_age(){
        this.age +=1;
    }

}
