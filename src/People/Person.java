package People;

import Interfaces.Set_food_demand_for_people;

/**
 * Abstrakcyjna klasa reprezentująca osobę.
 * Implementuje interfejs Set_food_demand_for_people.
 * Ta klasa służy jako klasa bazowa dla konkretnych typów osób.
 */
abstract public class Person implements Set_food_demand_for_people {
    protected int age;
    protected double potatoes;
    protected double apples;
    protected double bread;
    protected double cucumbers;
    protected double tomatoes;
    protected double meat;
    protected double water;

    /**
     * Metoda zwracająca wiek osoby.
     *
     * @return wiek osoby
     */
    public int getAge() {
        return age;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na wodę osoby.
     *
     * @return zapotrzebowanie na wodę osoby
     */
    public double getWater() {
        return water;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na pomidory osoby.
     *
     * @return zapotrzebowanie na pomidory osoby
     */
    public double getTomatoes() {
        return tomatoes;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na ziemniaki osoby.
     *
     * @return zapotrzebowanie na ziemniaki osoby
     */
    public double getPotatoes() {
        return potatoes;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na mięso osoby.
     *
     * @return zapotrzebowanie na mięso osoby
     */
    public double getMeat() {
        return meat;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na ogórki osoby.
     *
     * @return zapotrzebowanie na ogórki osoby
     */
    public double getCucumbers() {
        return cucumbers;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na chleb osoby.
     *
     * @return zapotrzebowanie na chleb osoby
     */
    public double getBread() {
        return bread;
    }

    /**
     * Metoda zwracająca zapotrzebowanie na jabłka osoby.
     *
     * @return zapotrzebowanie na jabłka osoby
     */
    public double getApples() {
        return apples;
    }

    /**
     * Metoda inkrementująca wiek osoby o 1.
     */
    public void add_age(){
        this.age += 1;
    }
}
