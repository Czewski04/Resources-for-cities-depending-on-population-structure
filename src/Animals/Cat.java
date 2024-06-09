package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

/**
 * Klasa zarządzająca obiektem Cat (Kot), która dziedziczy po klasie Pet
 * i implementuje interfejsy Get_food_demand_for_pets oraz Set_food_demand_for_pets.
 * Klasa ta reprezentuje kota jako zwierzę domowe.
 */

public class Cat extends Pet implements Get_food_demand_for_pets, Set_food_demand_for_pets {
    private double meat;

    /**
     * Konstruktor domyślny klasy Cat, który losowo ustawia wiek, zapotrzebowanie na wodę oraz mięso.
     */
    public Cat() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }

    /**
     * Konstruktor klasy Cat, który ustawia wiek na podaną wartość oraz losowo
     * ustawia zapotrzebowanie na wodę i mięso.
     *
     * @param age wiek kota
     */
    public Cat(int age){
        this.age = age;
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }

    /**
     * Metoda zwracająca zapotrzebowanie kota na mięso.
     *
     * @return zapotrzebowanie na mięso w kilogramach
     */
    public double Get_food_demand_for_pets(){ return meat; }

    /**
     * Metoda losowo ustawiająca zapotrzebowanie na wodę oraz mięso dla kota.
     */
    public void set_food_demand_for_pets(){
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }
}
