package Crops;

/**
 * Klasa reprezentująca uprawę ogórków, która dziedziczy po klasie Crops.
 * Ta klasa specjalizuje się w obsłudze upraw ogórków.
 */
public class Cucumber_crops extends Crops {

    /**
     * Konstruktor domyślny klasy Cucumber_crops, który ustawia czynnik powierzchni na 0.5
     * oraz czynnik wody na 10.
     */
    public Cucumber_crops(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }
}
