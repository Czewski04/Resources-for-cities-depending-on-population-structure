package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

/**
 * Abstrakcyjna klasa reprezentująca zwierzę domowe.
 * Implementuje interfejsy Get_food_demand_for_pets oraz Set_food_demand_for_pets.
 */
public abstract class Pet implements Get_food_demand_for_pets, Set_food_demand_for_pets {
    protected int age;
    protected double water;

    /**
     * Metoda zwracająca wiek zwierzęcia.
     *
     * @return wiek zwierzęcia
     */
    public int getAge() {
        return age;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na wodę zwierzęcia.
     *
     * @return zapotrzebowanie na wodę zwierzęcia
     */
    public double getWater() {
        return water;
    }

    /**
     * Metoda inkrementująca wiek zwierzęcia o 1.
     */
    public void add_age(){
        this.age +=1;
    }

}
