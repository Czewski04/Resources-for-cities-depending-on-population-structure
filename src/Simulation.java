import Crops.Crops;
import Crops.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Simulation {
    public int time;
    public ArrayList<City> list_of_cities = new ArrayList<>();

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
        System.out.println("Liczba kobiet: " + city.number_of_women());
        System.out.println("Liczba mężczyzn: " + city.number_of_men());
        System.out.println("Populacja zwierząt " + city.getPets_population());
        show_crop_area(city);
        show_food_demand(city);
        System.out.println("\n");
    }

    public boolean time_progress(){
        Scanner reading = new Scanner(System.in);
        int progress;
        int decision;
        while (true){
            if(list_of_cities_is_empty_check()) break;

            System.out.println("Jaki okres czasu chcesz dodać?: \n0 - Powrót do menu miast");

            progress = user_int_input();

            if(progress == 0) break;

            this.time += progress;
            for(int j = 0; j < progress; j++){
                for(int i = 0; i < list_of_cities.size(); i++){
                    list_of_cities.get(i).Clear();
                    list_of_cities.get(i).Time();
                    show_city_statistics(list_of_cities.get(i));
                    export_city_statistics_to_csv(list_of_cities.get(i).getName()+".csv", list_of_cities.get(i));
                    if (city_is_empty_check(list_of_cities.get(i))) i--;
                }
            }
        }
        while (true){
            System.out.println("Chcesz przejść do tworzenia kolejnych miast, edytować parametry, kontynuować symulację czy zakończyć program? \n1 - Twórz miasta lub kontynuuj symulację \n2 - Edutuj parametry istniejących miast \n0 - Zakończ program");
            decision = user_int_input();
            if(decision == 1) return true;
            else if(decision == 2){
                System.out.println("Przechodzisz do menu edycji współczynników");
                System.out.println("Podaj nazwę miasta, którego dane chcesz zmienić:");
                System.out.println("Lista aktualnei stworzoncyh miast: ");
                for(int i = 0; i < list_of_cities.size(); i++){
                    System.out.println(i+1 + ". " + list_of_cities.get(i).getName());
                }
                String cityName = reading.next();

                City city = find_city_by_name(cityName);
                if (city != null) {
                    changing_city_data(city);
                } else {
                    System.out.println("Miasto o podanej nazwie nie istnieje.");
                }
            }
            else if(decision == 0) break;
            else System.out.println("Podaj właściwą liczbę");
        }
        return false;
    }

    private City find_city_by_name(String city_name){
        for(City city : list_of_cities){
            if(city.getName().equals(city_name)){
                return city;
            }
        }
        return null;
    }

    public boolean creating_cities(){
        while(true){
            System.out.println("Aktualna liczba miast: " + list_of_cities.size());
            System.out.println("Chcesz stworzyć miasto? \n 1 - tak \n 2 - nie, przejdź do symulacji \n 0 - zakończ program");
            int decision = user_int_input();

            if(decision == 0) return true;
            else if(decision == 1){
                list_of_cities.add(getting_city_data());
                list_of_cities.getLast().Start();
                first_export_city_statistics_to_csv(list_of_cities.getLast().getName()+".csv", list_of_cities.getLast());
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
            list_of_cities.remove(city);
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
    public void first_export_city_statistics_to_csv(String filename, City city) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {

            writer.write("City Name,Population,Women,Men,Pets Population,Apple Demand,Bread Demand,Cucumber Demand,Meat Demand,Potato Demand,Seed Demand,Tomato Demand,Wheat Demand,Water Demand,Potato Crop,Apple Crop,Animal breeding,Cucumber crop,Tomato crop,Wheat crop\n");

            writer.write(city.getName() + "," +
                    city.getPopulation() + "," +
                    city.number_of_women() + "," +
                    city.number_of_men() + "," +
                    city.getPets_population() + "," +
                    city.getSum_of_apples() + "," +
                    city.getSum_of_bread() + "," +
                    city.getSum_of_cucumbers() + "," +
                    city.getSum_of_meat() + "," +
                    city.getSum_of_potatoes() + "," +
                    city.getSum_of_seeds() + "," +
                    city.getSum_of_tomatoes() + "," +
                    city.getSum_of_wheat() + "," +
                    city.getSum_of_water() + "," +
                    city.getList_of_crops().get(0).getCrop_area() + "," +
                    city.getList_of_crops().get(1).getCrop_area() + "," +
                    city.getList_of_crops().get(2).getCrop_area() + "," +
                    city.getList_of_crops().get(3).getCrop_area() + "," +
                    city.getList_of_crops().get(4).getCrop_area() + "," +
                    city.getList_of_crops().get(5).getCrop_area() + "\n");


            System.out.println("Dane zostały wyeksportowane do " + filename);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisu do pliku CSV: " + e.getMessage());
        }
    }

    public void export_city_statistics_to_csv(String filename, City city) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write( " ," +
                    city.getPopulation() + "," +
                    city.number_of_women() + "," +
                    city.number_of_men() + "," +
                    city.getPets_population() + "," +
                    city.getSum_of_apples() + "," +
                    city.getSum_of_bread() + "," +
                    city.getSum_of_cucumbers() + "," +
                    city.getSum_of_meat() + "," +
                    city.getSum_of_potatoes() + "," +
                    city.getSum_of_seeds() + "," +
                    city.getSum_of_tomatoes() + "," +
                    city.getSum_of_wheat() + "," +
                    city.getSum_of_water() + "," +
                    city.getList_of_crops().get(0).getCrop_area() + "," +
                    city.getList_of_crops().get(1).getCrop_area() + "," +
                    city.getList_of_crops().get(2).getCrop_area() + "," +
                    city.getList_of_crops().get(3).getCrop_area() + "," +
                    city.getList_of_crops().get(4).getCrop_area() + "," +
                    city.getList_of_crops().get(5).getCrop_area()+ "\n");

            System.out.println("Dane zostały wyeksportowane do " + filename);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisu do pliku CSV: " + e.getMessage());
        }
    }

    public static int user_int_input(){
        int decision = 0;
        boolean tmp = true;
        while(tmp){
            Scanner scanner = new Scanner(System.in);
            try{
                decision = scanner.nextInt();
                tmp = false;
            }
            catch(InputMismatchException e){
                System.out.println("Podaj liczbę!");
            }
        }
        return decision;
    }

    public static double user_double_input(){
        double decision = 0;
        boolean tmp = true;
        while(tmp){
            Scanner scanner = new Scanner(System.in);
            try{
                decision = scanner.nextDouble();
                tmp = false;
            }
            catch(InputMismatchException e){
                System.out.println("Podaj liczbę!");
            }
        }
        return decision;
    }

    public City getting_city_data() {
        Scanner reading_data = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta: ");
        String nazwa_miasta = reading_data.nextLine();

        System.out.println("Podaj początkową populację miasta: ");
        int population =user_int_input();

        System.out.println("Podaj kolejno procentowe szansy na: śmierć dziecka < 20 lat; śmierć osoby do 70 roku życia; śmierć osoby do 90 rok życia; śmierc osoby powyżej 90 roku życia:");
        double child_death_chance = user_double_input();
        double adult_death_chance = user_double_input();
        double senior_death_chance = user_double_input();
        double old_death_chance = user_double_input();

        System.out.println("Podaj kolejno współczynnik urodzień ludzi na 100 mieszkańców oraz współczynnik urodzień zwierząt na 100 mieszkańców ");
        double birth_rate = user_double_input();
        double animal_birth_rate = user_double_input();

        System.out.println("Podaj prawdopodobieństwo wystąpienia klęski żywiołowej: ");
        double natural_disaster_chance = user_double_input();

        return new City(nazwa_miasta, population, child_death_chance, adult_death_chance, senior_death_chance, old_death_chance, birth_rate, animal_birth_rate, natural_disaster_chance);
    }

    public void changing_city_data(City city){
        System.out.println("Podaj kolejno nowe procentowe szansy na: śmierć dziecka < 20 lat; śmierć osoby do 70 roku życia; śmierć osoby do 90 rok życia; śmierc osoby powyżej 90 roku życia:");
        double child_death_chance = user_double_input();
        double adult_death_chance = user_double_input();
        double senior_death_chance = user_double_input();
        double old_death_chance = user_double_input();

        System.out.println("Podaj kolejno nowe współczynnik urodzień ludzi na 100 mieszkańców oraz współczynnik urodzień zwierząt na 100 mieszkańców ");
        double birth_rate = user_double_input();
        double animal_birth_rate = user_double_input();

        System.out.println("Podaj nowe prawdopodobieństwo wystąpienia klęski żywiołowej: ");
        double natural_disaster_chance = user_double_input();

        city.setting_city_data(child_death_chance, adult_death_chance, senior_death_chance, old_death_chance, birth_rate, animal_birth_rate, natural_disaster_chance);
    }
    public void hello(){
        System.out.println("Witamy w naszej symulacji!\n");
        System.out.println("Projekt autorstwa: \n" +
                            "Wiktora Wilczewskiego oraz Alicji Matłok\n");
        System.out.println("W naszej symulacji możesz tworzyć nowe miasta, nadawać im nazwy " +
                           "\ni sam wybierać wartości podanych parametry.");
        System.out.println("Symulacja ta bierze pod uwagę zmieniającą się liczbę ludności w czasie " +
                           "\ni dostosowuje alokację zasobów, takich jak woda, żywność i inne, aby zaspokoić potrzeby mieszkańców.");
        System.out.println("Program uwzględnia również różne scenariusze, takie jak zmiany klimatyczne lub " +
                            "\nklęski żywiołowe które mogą wpływać na życie mieszkańców.\n");
        System.out.println("Wszystkie dane miast są przesyłane do CVS do późnijszego wglądu.\n");
    }

    public static void main(String[] args) {
        Simulation s = new Simulation();
        s.hello();

        do{
            if(s.creating_cities()) break;
        }while(s.time_progress());
    }

}

//testy jednostkowe
