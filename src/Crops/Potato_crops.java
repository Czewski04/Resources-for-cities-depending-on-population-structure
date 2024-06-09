package Crops;

/**
 * Klasa reprezentująca uprawę ziemniaków, która dziedziczy po klasie Crops.
 * Ta klasa specjalizuje się w obsłudze upraw ziemniaków.
 */
public class Potato_crops extends Crops {

    /**
     * Konstruktor domyślny klasy Potato_crops, który ustawia czynnik powierzchni na 0.5
     * oraz czynnik wody na 10.
     */
    public Potato_crops(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }
}
