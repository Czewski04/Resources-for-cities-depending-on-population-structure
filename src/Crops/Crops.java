package Crops;

/**
 * Klasa reprezentująca ogólne parametry upraw, służy jako klasa bazowa dla konkretnych typów upraw.
 * Zawiera podstawowe właściwości takie jak powierzchnia uprawy i zapotrzebowanie na wodę.
 */
public class Crops {
    protected double crop_area;
    protected double water_demand;
    protected double area_factor;
    protected double water_factor;

    /**
     * Metoda zwracająca powierzchnię uprawy.
     *
     * @return powierzchnia uprawy
     */
    public double getCrop_area() {
        return crop_area;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na wodę.
     *
     * @return zapotrzebowanie na wodę
     */
    public double getWater_demand() {
        return water_demand;
    }

    /**
     * Metoda obliczająca parametry uprawy na podstawie sumy jedzenia.
     * Używa czynników powierzchni i wody do obliczenia powierzchni uprawy
     * i zapotrzebowania na wodę.
     *
     * @param sum_of_food suma jedzenia
     */
    public void calculate_crop_parameters(double sum_of_food) {
        this.crop_area = area_factor * sum_of_food;
        this.water_demand = crop_area * water_factor;
    }
}
