package Crops;

/**
 * Klasa reprezentująca uprawę pomidorów, która dziedziczy po klasie Crops.
 * Ta klasa specjalizuje się w obsłudze upraw pomidorów.
 */
public class Tomato_crops extends Crops {
    /**
     * Konstruktor domyślny klasy Tomato_crops, który ustawia czynnik powierzchni na 0.5
     * oraz czynnik wody na 10.
     */
    public Tomato_crops(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }
}
