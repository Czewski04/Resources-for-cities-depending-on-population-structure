package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

/**
 * Klasa zarządzająca obiektem Dog (Pies), która dziedziczy po klasie Pet
 * i implementuje interfejsy Get_food_demand_for_pets oraz Set_food_demand_for_pets.
 * Klasa ta reprezentuje psa jako zwierzę domowe.
 */
public class Dog extends Pet implements Get_food_demand_for_pets, Set_food_demand_for_pets {
    private double meat;

    /**
     * Konstruktor domyślny klasy Dog, który losowo ustawia wiek, zapotrzebowanie na wodę oraz mięso.
     */
    public Dog() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }

    /**
     * Konstruktor klasy Dog, który ustawia wiek na podaną wartość oraz losowo
     * ustawia zapotrzebowanie na wodę i mięso.
     *
     * @param age wiek psa
     */
    public Dog(int age){
        this.age = age;
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }

    /**
     * Metoda zwracająca zapotrzebowanie psa na mięso.
     *
     * @return zapotrzebowanie na mięso w kilogramach
     */
    public double Get_food_demand_for_pets(){
        return meat;
    }

    /**
     * Metoda losowo ustawiająca zapotrzebowanie na wodę oraz mięso dla psa.
     */
    public void set_food_demand_for_pets(){
        this.water = Math.random()*(4-1)+1;
        this.meat = Math.random()*(5-1)+1;
    }
}
