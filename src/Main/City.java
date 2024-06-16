package Main;

import Animals.Cat;
import Animals.Dog;
import Animals.Pet;
import Animals.Rodent;
import Crops.Crops;
import People.Man;
import People.Person;
import People.Woman;
import Crops.Apple_crops;
import Crops.Cucumber_crops;
import Crops.Potato_crops;
import Crops.Animal_breeding;
import Crops.Tomato_crops;
import Crops.Wheat_crops;

import java.util.ArrayList;

/**
 * Klasa reprezentująca miasto w symulacji.
 */
public class City {
    private String name;
    private int population;
    private int pets_population;
    private ArrayList<Person> list_of_residents = new ArrayList<>();
    private ArrayList<Pet> list_of_pets = new ArrayList<>();
    private ArrayList<Crops> list_of_crops = new ArrayList<>();
    private double sum_of_potatoes;
    private double sum_of_apples;
    private double sum_of_bread;
    private double sum_of_cucumbers;
    private double sum_of_tomatoes;
    private double sum_of_meat;
    private double sum_of_water;
    private double sum_of_seeds;
    private double sum_of_wheat;
    private double child_death_chance;
    private double adult_death_chance;
    private double senior_death_chance;
    private double old_death_chance;
    private double birth_rate;
    private double animal_birth_rate;
    private double natural_disaster_chance;

    /**
     * Konstruktor klasy main.City.
     */
    public City(String name, int population, double child_death_chance, double adult_death_chance, double senior_death_chance, double old_death_chance, double birth_rate, double animal_birth_rate, double natural_disaster_chance) {
        this.name = name;
        this.population = population;
        this.pets_population = (int) Math.round(population/((Math.random()*(10-2))+2));
        this.child_death_chance = child_death_chance;
        this.adult_death_chance = adult_death_chance;
        this.senior_death_chance = senior_death_chance;
        this.old_death_chance = old_death_chance;
        this.birth_rate = birth_rate;
        this.animal_birth_rate = animal_birth_rate;
        this.natural_disaster_chance = natural_disaster_chance;
    }


    /**
     * Ustawia dane miasta.
     */
    public void setting_city_data(double child_death_chance, double adult_death_chance, double senior_death_chance, double old_death_chance, double birth_rate, double animal_birth_rate, double natural_disaster_chance){
        this.child_death_chance = child_death_chance;
        this.adult_death_chance = adult_death_chance;
        this.senior_death_chance = senior_death_chance;
        this.old_death_chance = old_death_chance;
        this.birth_rate = birth_rate;
        this.animal_birth_rate = animal_birth_rate;
        this.natural_disaster_chance = natural_disaster_chance;
    }


    /**
     * Funkcja generująca mieszkańców miasta.
     */
    public void generate_residents(){
        double people_max = 3.5;
        double people_min = 1.4;

        double pet_max = 2;
        double pet_min = 1.5;

        //generowanie ludzi
        int men = (int) Math.round(this.population/((Math.random()*(people_max-people_min))+people_min));
        int women = this.population-men;


        for(int i = 0; i < men; i++){
            this.list_of_residents.add(new Man());
        }

        for(int i = 0; i < women; i++){
            this.list_of_residents.add(new Woman());
        }

        //generowanie zwierząt
        int dogs = (int) Math.round(pets_population/((Math.random()*(pet_max-pet_min))+pet_min));
        int cats = (int) Math.round((pets_population-dogs)/((Math.random()*(pet_max-pet_min))+pet_min));
        int rodnets = pets_population-dogs-cats;

        for(int i = 0; i < dogs; i++){
            this.list_of_pets.add(new Dog());
        }
        for(int i = 0; i < cats; i++){
            this.list_of_pets.add(new Cat());
        }
        for(int i = 0; i < rodnets; i++){
            this.list_of_pets.add(new Rodent());
        }
    }

    /**
     * Funckaj obliczająca zasoby miasta bez wody
     */
    public void calcualte_sum_without_water(){ //obliczanie zapotrzebowania na surowece (bez wody)
        //zliczanie zapotrzebowania populacji
        for(int i = 0; i < population; i++){
            this.sum_of_potatoes += list_of_residents.get(i).getPotatoes();
            this.sum_of_apples += list_of_residents.get(i).getApples();
            this.sum_of_meat += list_of_residents.get(i).getMeat();
            this.sum_of_cucumbers += list_of_residents.get(i).getCucumbers();
            this.sum_of_tomatoes += list_of_residents.get(i).getTomatoes();
            this.sum_of_bread += list_of_residents.get(i).getBread();
            this.sum_of_wheat += list_of_residents.get(i).getBread(); //z 1kg pszenicy mamy +- 1kg chleba
        }

        //zliczanie zapotrzebowania zwierząt
        for(int i = 0; i < pets_population; i++){
            if(list_of_pets.get(i) instanceof Rodent){
                this.sum_of_seeds += list_of_pets.get(i).Get_food_demand_for_pets();
                this.sum_of_wheat += list_of_pets.get(i).Get_food_demand_for_pets();
            }
            else
                this.sum_of_meat += list_of_pets.get(i).Get_food_demand_for_pets();
        }
    }

    /**
     * Funckaj obliczająca potrzebną wodę
     */
    public void calculate_sum_of_water(){ //obliczanie zapotrzebowania na wode wraz z polami uprawnymi
        //zliczanie zapotrzebowania pól
        for (Crops listOfCrop : list_of_crops) {
            this.sum_of_water += listOfCrop.getWater_demand();
        }
        //woda dla zwierzat
        for(int i = 0; i < pets_population; i++){
            this.sum_of_water += list_of_pets.get(i).getWater();
        }
        //woda dla ludzi
        for(int i = 0; i < population; i++){
            this.sum_of_water += list_of_residents.get(i).getWater();
        }
    }

    /**
     * Dodawanie pól uprawnych do miasta
     */
    public void generating_crops(){
        // dodawanie pól każdego rodzaju do miasta
        list_of_crops.add(new Potato_crops());
        list_of_crops.add(new Apple_crops());
        list_of_crops.add(new Animal_breeding());
        list_of_crops.add(new Cucumber_crops());
        list_of_crops.add(new Tomato_crops());
        list_of_crops.add(new Wheat_crops());
    }


    /**
     * Przekazywanie zapotrzebowania do pól uprawnych
     */
    public void cultivating_fields(){
        //przekazywanie zapotrzebowania do pól uprawnych
        list_of_crops.get(0).calculate_crop_parameters(sum_of_potatoes);
        list_of_crops.get(1).calculate_crop_parameters(sum_of_apples);
        list_of_crops.get(2).calculate_crop_parameters(sum_of_meat);
        list_of_crops.get(3).calculate_crop_parameters(sum_of_cucumbers);
        list_of_crops.get(4).calculate_crop_parameters(sum_of_tomatoes);
        list_of_crops.get(5).calculate_crop_parameters(sum_of_wheat);
    }


    /**
     * Uśmiercanie mieszkańców
     */
    public void death(){   //losowanie śmierci
        for(int i = 0; i < list_of_residents.size(); i++){  //losowanie śmierci dla ludzi
            if(list_of_residents.get(i).getAge()<20){
                if((Math.random()*(1000))/10<this.child_death_chance){
                    list_of_residents.remove(i);
                    i--;
                }
            }
            else if(list_of_residents.get(i).getAge()<70){
                if((Math.random()*(1000))/10<this.adult_death_chance){
                    list_of_residents.remove(i);
                    i--;
                }
            }
            else if(list_of_residents.get(i).getAge()<90){
                if((Math.random()*(1000))/10<this.senior_death_chance){
                    list_of_residents.remove(i);
                    i--;
                }
            }
            else {
                if ((Math.random() * (1000)) / 10 < this.old_death_chance) {
                    list_of_residents.remove(i);
                    i--;
                }
            }
        }
        this.population = list_of_residents.size();

        for(int i = 0; i < list_of_pets.size(); i++){   //losowanie śmierci dla zwierząt
            if(list_of_pets.get(i).getAge()<2){
                if((Math.random()*(1000))/10 < this.child_death_chance){
                    list_of_pets.remove(i);
                    i--;
                }
            }
            else if(list_of_pets.get(i).getAge()<12){
                if((Math.random()*(1000))/10 < this.adult_death_chance){
                    list_of_pets.remove(i);
                    i--;
                }
            }
            else if(list_of_pets.get(i).getAge()<16){
                if((Math.random()*(1000))/10 < this.senior_death_chance){
                    list_of_pets.remove(i);
                    i--;
                }
            }
            else {
                if ((Math.random() * (1000)) / 10 < this.old_death_chance) {
                    list_of_pets.remove(i);
                    i--;
                }
            }
        }
        this.pets_population = list_of_pets.size();

    }

    /**
     * Losuje nowe narodziny mieszkańców miasta.
     */
    public void born(){
        // Liczenie liczby narodzin
        int number_of_births = (int)Math.round(this.birth_rate*this.population/100);
        int men = Math.round(number_of_births*((float)(Math.round(Math.random() * (60 - 40) + 40)) /100));
        int women = number_of_births-men;

        // Dodawanie nowych mieszkańców (mężczyzn i kobiet)
        for(int i = 0; i < men; i++){
            list_of_residents.add(new Man(0));
        }
        for(int i = 0; i < women; i++){
            list_of_residents.add(new Woman(0));
        }
        this.population = list_of_residents.size();

        // Liczenie liczby narodzin zwierząt
        int number_of_animal_births = (int)Math.round(this.animal_birth_rate*this.population/100);
        int cats = Math.round(number_of_animal_births*((float)(Math.round(Math.random() * (20 - 40) + 40)) /100));
        number_of_animal_births = number_of_animal_births - cats;
        int dogs = Math.round(number_of_animal_births*((float)(Math.round(Math.random() * (60 - 40) + 40)) /100));
        int rodnets = number_of_animal_births-dogs;

        // Dodawanie nowych zwierząt (kotów, psów, gryzoni)
        for(int i = 0; i < cats; i++){
            list_of_pets.add(new Cat(0));
        }
        for(int i = 0; i < dogs; i++){
            list_of_pets.add(new Dog(0));
        }
        for(int i = 0; i < rodnets; i++){
            list_of_pets.add(new Rodent(0));
        }
        this.pets_population = list_of_pets.size();
    }

    public void Start(){
        generate_residents();
        generating_crops();
        calcualte_sum_without_water();
        cultivating_fields();
        calculate_sum_of_water();
    }

    /**
     * Symuluje działanie miasta w kolejnym okresie czasu.
     */
    public void Time(){
        // Starzenie się mieszkańców
        for(Person resident : list_of_residents){
            resident.add_age();
            resident.set_food_demand();
        }

        // Starzenie się zwierząt
        for(Pet pet : list_of_pets){
            pet.add_age();
            pet.set_food_demand_for_pets();
        }

        // Narodziny i śmierć
        born();
        death();

        // Symulacja klęsk naturalnych
        natural_disaster();
        // Ponowne obliczenie zapotrzebowania i upraw
        calcualte_sum_without_water();
        cultivating_fields();
        // Obliczenie zapotrzebowania na wodę
        calculate_sum_of_water();
    }

    /**
     * Czyści sumy zapotrzebowania na surowce i wodę.
     */
    public void Clear(){
        sum_of_apples = 0;
        sum_of_bread = 0;
        sum_of_cucumbers = 0;
        sum_of_meat = 0;
        sum_of_potatoes = 0;
        sum_of_seeds = 0;
        sum_of_tomatoes = 0;
        sum_of_water = 0;
        sum_of_wheat = 0;
    }

    /**
     * Symuluje wystąpienie klęski naturalnej, losowo decydując o jej rodzaju i skutkach.
     */
    public void natural_disaster(){
        // Losowanie wydarzenia losowego
        double random_event = Math.random()*(1000)/10;
        if(random_event<=natural_disaster_chance){
            int population_before_disaster = this.population;
            int pets_population_before_disaster = this.pets_population;
            random_event = Math.random()*(1000)/10;

            // Określenie skutków klęski w zależności od wylosowanego zdarzenia
            if(random_event<10){
                this.population = (int)Math.round(this.population*0.5);
                this.pets_population = (int)Math.round(this.pets_population*0.5);
                System.out.println("Twoje miasto zostało zdziesiątkowane przez epidemię! Utraciłeś/aś 50% mieszkańców");
            }
            else if(random_event<33.33){
                this.population = (int)Math.round(this.population*0.6666);
                this.pets_population = (int)Math.round(this.pets_population*0.6666);
                System.out.println("Twoje miasto na sktuek konfliktu zbrojnego utraciło 33% mieszkańców!");
            }
            else if(random_event<63.33){
                this.population = (int)Math.round(this.population*0.8);
                this.pets_population = (int)Math.round(this.pets_population*0.8);
                System.out.println("Na skutek wybuchu wulkanu utraciłeś/łaś 20% mieszkańców!");
            }
            else if(random_event<99){
                this.population = (int)Math.round(this.population*0.9);
                this.pets_population = (int)Math.round(this.pets_population*0.9);
                System.out.println("Twoje miasto straciło 10% mieszkańców w wyniku huraganu!");
            }
            else {
                this.population = 0;
                this.pets_population = 0;
                System.out.println("Niestety Twoje miasto spotkał niezwykle rzadki pech i zostało ono trafione przez asteroidę! Wszyscy zgineli!");
            }

            // Usuwanie losowo wybranych mieszkańców z listy w zależności od liczby zmarłych
            for(int i = 0; i<population_before_disaster-this.population; i++){
                list_of_residents.remove((int)(Math.random()*(list_of_residents.size()-1)));
            }

            // Usuwanie losowo wybranych zwierząt z listy w zależności od liczby zmarłych
            for(int i = 0; i<pets_population_before_disaster-this.pets_population; i++){
                list_of_pets.remove((int)(Math.random()*(list_of_pets.size()-1)));
            }
        }
    }

    /**
     * Zwraca liczbę kobiet w populacji miasta.
     * @return Liczba kobiet.
     */
    public int number_of_women(){
        int women = 0;
        for(Person resident : list_of_residents){
            if(resident instanceof Woman){
                women++;
            }
        }
        return women;
    }

    /**
     * Zwraca liczbę mężczyzn w populacji miasta.
     * @return Liczba mężczyzn.
     */
    public int number_of_men(){
        int men;
        men = this.population - number_of_women();
        return men;
    }

    /**
     * Zwraca listę upraw w mieście.
     * @return Lista upraw.
     */
    public ArrayList<Crops> getList_of_crops() {
        return list_of_crops;
    }

    /**
     * Zwraca listę zwierząt w mieście.
     * @return Lista zwierząt.
     */
    public ArrayList<Pet> getList_of_pets() {
        return list_of_pets;
    }

    /**
     * Zwraca listę mieszkańców miasta.
     * @return Lista mieszkańców.
     */
    public ArrayList<Person> getList_of_residents() {
        return list_of_residents;
    }

    /**
     * Zwraca nazwę miasta.
     * @return Nazwa miasta.
     */
    public String getName() {
        return name;
    }

    /**
     * Zwraca liczbę ludności w mieście.
     * @return Liczba ludności.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Zwraca liczbę zwierząt w mieście.
     * @return Liczba zwierząt.
     */
    public int getPets_population() {
        return pets_population;
    }

    /**
     * Zwraca sumę zapotrzebowania na jabłka.
     * @return Suma zapotrzebowania na jabłka.
     */
    public double getSum_of_apples() {
        return sum_of_apples;
    }

    /**
     * Zwraca sumę zapotrzebowania na chleb.
     * @return Suma zapotrzebowania na chleb.
     */
    public double getSum_of_bread() {
        return sum_of_bread;
    }

    /**
     * Zwraca sumę zapotrzebowania na ogórki.
     * @return Suma zapotrzebowania na ogórki.
     */
    public double getSum_of_cucumbers() {
        return sum_of_cucumbers;
    }

    /**
     * Zwraca sumę zapotrzebowania na mięso.
     * @return Suma zapotrzebowania na mięso.
     */
    public double getSum_of_meat() {
        return sum_of_meat;
    }

    /**
     * Zwraca sumę zapotrzebowania na ziemniaki.
     * @return Suma zapotrzebowania na ziemniaki.
     */
    public double getSum_of_potatoes() {
        return sum_of_potatoes;
    }

    /**
     * Zwraca sumę zapotrzebowania na nasiona.
     * @return Suma zapotrzebowania na nasiona.
     */
    public double getSum_of_seeds() {
        return sum_of_seeds;
    }

    /**
     * Zwraca sumę zapotrzebowania na pomidory.
     * @return Suma zapotrzebowania na pomidory.
     */
    public double getSum_of_tomatoes() {
        return sum_of_tomatoes;
    }

    /**
     * Zwraca sumę zapotrzebowania na wodę.
     * @return Suma zapotrzebowania na wodę.
     */
    public double getSum_of_water() {
        return sum_of_water;
    }

    /**
     * Zwraca sumę zapotrzebowania na pszenicę.
     * @return Suma zapotrzebowania na pszenicę.
     */
    public double getSum_of_wheat(){
        return sum_of_wheat;
    }

}
