import Crops.Crops;
import Crops.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public int time;
    public ArrayList<City> list_of_cities = new ArrayList<City>();

    public void show_crop_area(City city) {
        for (Crops crop : city.getList_of_crops()) {
            if (crop instanceof Potato_crops) {
                System.out.println("Potrzebna ilość pól uprawnych na ziemniaki: " + crop.getCrop_area());
            } else if (crop instanceof Apple_crops) {
                System.out.println("Potrzebna ilość pól uprawnych na jabłka: " + crop.getCrop_area());
            } else if (crop instanceof Wheat_crops) {
                System.out.println("Potrzebna ilośś pól uprawnych na zboże: " + crop.getCrop_area());
            } else if (crop instanceof Cucumber_crops) {
                System.out.println("Potrzebna ilość pól uprawnych na ogórki: " + crop.getCrop_area());
            } else if (crop instanceof Tomato_crops) {
                System.out.println("Potrzebna ilość pól uprawnych na pomidory: " + crop.getCrop_area());
            } else if (crop instanceof Animal_breeding) {
                System.out.println("Potrzebna ilość powierzchni na hodowlę zwierząt: " + crop.getCrop_area());
            }
        }
    }


    public void show_food_demand(City city){
        System.out.println("Zapotrzebowanie na jabłka: " + city.getSum_of_apples());
        System.out.println("Zapotrzebowanie na chleb: " + city.getSum_of_bread());
        System.out.println("Zapotrzebowanie na ogórki: " + city.getSum_of_cucumbers());
        System.out.println("Zapotrzebowanie na mięso: " + city.getSum_of_meat());
        System.out.println("Zapotrzebowanie na ziemniaki: " + city.getSum_of_potatoes());
        System.out.println("Zapotrzebowanie na karmę dla gryzoni: " + city.getSum_of_seeds());
        System.out.println("Zapotrzebowanie na pomidory: " + city.getSum_of_tomatoes());
        System.out.println("Zapotrzebowanie na zboże: " + city.getSum_of_wheat());
        System.out.println("Zapotrzebowanie na wodę: " + city.getSum_of_water());
    }

    public void show_city_statistics(City city){
        System.out.println("\nOto statystyki miasta " + city.getName());
        System.out.println("Populacja " + city.getPopulation());
        System.out.println("Populacja zwierząt " + city.getPets_population());
        show_crop_area(city);
        show_food_demand(city);
        System.out.println("\n");
    }

    public boolean time_progress(){
        Scanner reading = new Scanner(System.in);
        int progress = 0;
        int decision = 0;
        while (true){
            if(list_of_cities_is_empty_check()) break;

            System.out.println("Jaki okres czasu chcesz dodać: ");
            progress = reading.nextInt();

            this.time += progress;
            for(int j = 0; j<progress; j++){
                for(int i = 0; i < list_of_cities.size(); i++){
                    list_of_cities.get(i).Clear();
                    list_of_cities.get(i).Time();
                    show_city_statistics(list_of_cities.get(i));
                    if (city_is_empty_check(list_of_cities.get(i))) i--;
                }
            }
        }
        while (true){
            System.out.println("Chcesz przejść do tworzenia kolejnych miast, czy zakończyć program? \n1 - Twórz miasta \n2-Zakończ program");
            decision = reading.nextInt();
            if(decision == 1) return true;
            if(decision == 2) break;
            else System.out.println("Podaj właśiwą liczbę");
        }
        return false;
    }

    public boolean creating_cities(){
        Scanner reading = new Scanner(System.in);
        while(true){
            System.out.println("Aktualna liczba miast: " + list_of_cities.size());
            System.out.println("Chcesz stworzyć miasto? \n 1 - tak \n 2 - nie, przejdź do symulacji \n 0 - zakończ program");
            int decision = reading.nextInt();
            if(decision == 0) return true;
            else if(decision == 1){
                list_of_cities.add(City.getting_city_data());
                list_of_cities.getLast().Start();
            }
            else if (decision == 2 && list_of_cities.isEmpty()) {
                System.out.println("Twoja symualcja nie może się odbyć, gdyż nie utworzyłeś ani jednego miasta!");
            }
            else if(decision<1 || decision>2){
                System.out.println("Podaj właściwą opcję w menu!");
            }
            else {
                for (City listOfCity : list_of_cities) {
                    show_city_statistics(listOfCity);
                }
                break;
            }
        }
        return false;
    }

    public boolean city_is_empty_check(City city){
        if (city.getPopulation() == 0){
            System.out.println("Miasto " + city.getName() + " zostało usunięte z powodu braku mieszkańców!");
            list_of_cities.remove(list_of_cities.indexOf(city));
            return true;
        }
        else return false;
    }

    public boolean list_of_cities_is_empty_check(){
        if(list_of_cities.isEmpty()){
            System.out.println("Twoja lista miast jest pusta! Nie można dalej prowdzaić symulacji!");
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        Simulation s = new Simulation();

        do{
            if(s.creating_cities()) break;
        }while(s.time_progress());
    }
}

// do zrobienia menu miasta
// do zrobienia export do csv

