import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public int time;
    public ArrayList<City> list_of_cities = new ArrayList<City>();

    public void show_crop_area(City city){

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

    public void time_progress(){
        Scanner reading = new Scanner(System.in);
        int progress = 0;
        while (true){
            for(int i=0; i<this.list_of_cities.size(); i++){
                System.out.println("Oto statystyki miasta " + list_of_cities.get(i).getName());
                System.out.println("Populacja " + list_of_cities.get(i).getPopulation());
                show_food_demand(list_of_cities.get(i));
            }

            System.out.println("Jaki okres czasu chcesz dodać: ");
            progress = reading.nextInt();

            this.time += progress;
            for(int i=0; i<this.list_of_cities.size(); i++){
                list_of_cities.get(i).Time();
            }

        }

    }

    public void creating_cities(){
        Scanner reading = new Scanner(System.in);
        while(true){
            System.out.println("Chcesz stworzyć miasto? \n 1 - tak \n 2 - nie, przejdź do symulacji");
            int decision = reading.nextInt();
            if(decision == 1){
                list_of_cities.add(City.getting_city_data());
                list_of_cities.getLast().Start();
            }
            else if (decision == 2 && list_of_cities.isEmpty()) {
                System.out.println("Twoja symualcja nie może się odbyć, gdyż nie utworzyłeś ani jednego miasta!");
            }
            else if(decision<1 || decision>2){
                System.out.println("Podaj właściwą opcję w menu!");
            }
            else break;
        }
    }

    public static void main(String[] args) {
        Simulation s = new Simulation();

        s.creating_cities();
        s.time_progress();
    }
}
