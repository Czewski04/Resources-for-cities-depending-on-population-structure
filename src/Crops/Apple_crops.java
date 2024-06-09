package Crops;

/**
 * Klasa reprezentująca uprawę jabłoni, która dziedziczy po klasie Crops.
 * Ta klasa specjalizuje się w obsłudze upraw jabłoni.
 */
public class Apple_crops extends Crops {

    /**
     * Konstruktor domyślny klasy Apple_crops, który ustawia czynnik powierzchni na 0.5
     * oraz czynnik wody na 10.
     */
    public Apple_crops(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }
}
