package People;

import Interfaces.Set_food_demand_for_people;

/**
 * Klasa reprezentująca kobietę.
 * Dziedziczy po klasie Person i implementuje interfejs Set_food_demand_for_people.
 * Ta klasa określa zapotrzebowanie żywieniowe kobiety w różnych przedziałach wiekowych.
 */
public class Woman extends Person implements Set_food_demand_for_people {

    /**
     * Konstruktor domyślny klasy Woman, który losowo ustawia wiek i oblicza zapotrzebowanie żywieniowe.
     */
    public Woman(){
        this.age = (int)Math.round((Math.random()*(100-1))+1);
        set_food_demand();
    }

    /**
     * Konstruktor klasy Woman, który ustawia wiek na podaną wartość i oblicza zapotrzebowanie żywieniowe.
     *
     * @param age wiek kobiety
     */
    public Woman(int age){
        this.age = age;
        set_food_demand();
    }

    /**
     * Metoda obliczająca zapotrzebowanie żywieniowe kobiety w zależności od jej wieku.
     */
    public void set_food_demand(){
        if(age<10){
            this.potatoes = Math.random();
            this.apples = Math.random();
            this.bread = (Math.random()*(1.5));
            this.meat = Math.random();
            this.cucumbers = (Math.random()*(0.5));
            this.tomatoes = Math.random();
            this.water = Math.random()*(14-3.5)+3.5;
        }
        else if(age<18){
            this.potatoes = (Math.random()*(1.9));
            this.apples = (Math.random()*(1.4));
            this.bread = (Math.random()*(1.3));
            this.meat = (Math.random()*(1.5));
            this.cucumbers = (Math.random()*0.8);
            this.tomatoes = Math.random()*0.8;
            this.water = Math.random()*(21-7)+7;
        } else if (age < 70) {
            this.potatoes = (Math.random()*(3.8));
            this.apples = (Math.random()*(3.8));
            this.bread = (Math.random()*(2.8));
            this.meat = (Math.random()*(3));
            this.cucumbers = (Math.random()*1.8);
            this.tomatoes = Math.random()*(1.6);
            this.water = Math.random()*(28-7)+7;
        }
        else{
            this.potatoes = (Math.random()*(1.2));
            this.apples = (Math.random());
            this.bread = (Math.random()*(1.1));
            this.meat = (Math.random()*(1.1));
            this.cucumbers = (Math.random()*0.6);
            this.tomatoes = Math.random()*(0.5);
            this.water = Math.random()*(21-7)+7;
        }
    }
}
