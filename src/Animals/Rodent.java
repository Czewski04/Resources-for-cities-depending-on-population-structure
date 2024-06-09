package Animals;

import Interfaces.Get_food_demand_for_pets;
import Interfaces.Set_food_demand_for_pets;

/**
 * Klasa reprezentująca gryzonia, która dziedziczy po klasie Pet
 * oraz implementuje interfejsy Get_food_demand_for_pets oraz Set_food_demand_for_pets.
 * Klasa ta reprezentuje gryzonia jako zwierzę domowe.
 */

public class Rodent extends Pet implements Set_food_demand_for_pets, Get_food_demand_for_pets {
    private double seeds;

    /**
     * Konstruktor domyślny klasy Rodent, który losowo ustawia wiek, zapotrzebowanie na wodę oraz ziarna.
     */
    public Rodent() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }

    /**
     * Konstruktor klasy Rodent, który ustawia wiek na podaną wartość oraz losowo
     * ustawia zapotrzebowanie na wodę i ziarna.
     *
     * @param age wiek gryzonia
     */
    public Rodent(int age){
        this.age = age;
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }

    /**
     * Metoda zwracająca zapotrzebowanie gryzonia na ziarna.
     *
     * @return zapotrzebowanie na ziarna w kilogramach
     */
    public double Get_food_demand_for_pets(){
        return seeds;
    }

    /**
     * Metoda losowo ustawiająca zapotrzebowanie na wodę oraz ziarna dla gryzonia.
     */
    public void set_food_demand_for_pets(){
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }
}
