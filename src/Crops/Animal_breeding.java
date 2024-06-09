package Crops;

/**
 * Klasa reprezentująca hodowlę zwierząt, która dziedziczy po klasie Crops.
 * Ta klasa specjalizuje się w obsłudze upraw hodowlanych zwierząt.
 */
public class Animal_breeding extends Crops {

    /**
     * Konstruktor domyślny klasy Animal_breeding, który ustawia czynnik powierzchni na 0.5
     * oraz czynnik wody na 10.
     */
    public Animal_breeding(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }
}
