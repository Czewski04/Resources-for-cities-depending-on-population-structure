package Crops;

/**
 * Klasa reprezentująca uprawę pszenicy, która dziedziczy po klasie Crops.
 * Ta klasa specjalizuje się w obsłudze upraw pszenicy.
 */
public class Wheat_crops extends Crops {

    /**
     * Konstruktor domyślny klasy Wheat_crops, który ustawia czynnik powierzchni na 0.5
     * oraz czynnik wody na 10.
     */
    public Wheat_crops(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }
}
