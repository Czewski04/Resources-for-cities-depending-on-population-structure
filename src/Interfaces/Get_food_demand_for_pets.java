package Interfaces;

/**
 * Interfejs definiujący metodę do uzyskiwania zapotrzebowania na jedzenie dla zwierząt.
 * Klasy implementujące ten interfejs muszą zaimplementować metodę Get_food_demand_for_pets(),
 * która zwraca zapotrzebowanie na jedzenie dla zwierząt w postaci liczby zmiennoprzecinkowej.
 */
public interface Get_food_demand_for_pets {

    /**
     * Metoda zwracająca zapotrzebowanie na jedzenie dla zwierząt.
     *
     * @return zapotrzebowanie na jedzenie dla zwierząt
     */
    public double Get_food_demand_for_pets();
}
