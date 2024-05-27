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

public class City {
    private String name;
    private int population;
    private int pets_population;
    private ArrayList<Person> list_of_residents = new ArrayList<Person>();
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

    public City(String name, int population) {
        this.name = name;
        this.population = population;
        this.pets_population = (int) Math.round(population/((Math.random()*(10-2))+2));
    }

    public ArrayList<Crops> getList_of_crops() {
        return list_of_crops;
    }

    public ArrayList<Pet> getList_of_pets() {
        return list_of_pets;
    }

    public ArrayList<Person> getList_of_residents() {
        return list_of_residents;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getSum_of_apples() {
        return sum_of_apples;
    }

    public double getSum_of_bread() {
        return sum_of_bread;
    }

    public double getSum_of_cucumbers() {
        return sum_of_cucumbers;
    }

    public double getSum_of_meat() {
        return sum_of_meat;
    }

    public double getSum_of_potatoes() {
        return sum_of_potatoes;
    }

    public double getSum_of_seeds() {
        return sum_of_seeds;
    }

    public double getSum_of_tomatoes() {
        return sum_of_tomatoes;
    }

    public double getSum_of_water() {
        return sum_of_water;
    }

    public double getSum_of_wheat(){
        return sum_of_wheat;
    }

    public void generate_residents(){
        double people_max = 3.5;
        double people_min = 1.4;

        double pet_max = 2;
        double pet_min = 1.5;

        //generowanie ludzi
        int men = (int) Math.round(this.population/((Math.random()*(people_max-people_min))+people_min));
        int women = this.population-men;


        for(int i=0; i<men; i++){
            this.list_of_residents.add(new Man());
        }

        for(int i=0; i<women; i++){
            this.list_of_residents.add(new Woman());
        }

        //generowanie zwierząt
        int dogs = (int) Math.round(pets_population/((Math.random()*(pet_max-pet_min))+pet_min));
        int cats = (int) Math.round((pets_population-dogs)/((Math.random()*(pet_max-pet_min))+pet_min));
        int rodnets = pets_population-dogs-cats;

        for(int i=0; i<dogs; i++){
            this.list_of_pets.add(new Dog());
        }
        for(int i=0; i<cats; i++){
            this.list_of_pets.add(new Cat());
        }
        for(int i=0; i<rodnets; i++){
            this.list_of_pets.add(new Rodent());
        }
    }

    public void calcualte_sum_without_water(){
        //zliczanie zapotrzebowania populacji
        for(int i=0; i<population; i++){
            this.sum_of_potatoes += list_of_residents.get(i).getPotatoes();
            this.sum_of_apples += list_of_residents.get(i).getApples();
            this.sum_of_meat += list_of_residents.get(i).getMeat();
            this.sum_of_cucumbers += list_of_residents.get(i).getCucumbers();
            this.sum_of_tomatoes += list_of_residents.get(i).getTomatoes();
            this.sum_of_bread += list_of_residents.get(i).getBread();
            this.sum_of_wheat += list_of_residents.get(i).getBread(); //z 1kg pszenicy mamy +- 1kg chleba
        }

        //zliczanie zapotrzebowania zwierząt
        for(int i=0; i<pets_population; i++){
            if(list_of_pets.get(i) instanceof Rodent){
                this.sum_of_seeds += list_of_pets.get(i).Get_food_demand_for_pets();
                this.sum_of_wheat += list_of_pets.get(i).Get_food_demand_for_pets();
            }
            else
                this.sum_of_meat += list_of_pets.get(i).Get_food_demand_for_pets();
        }
    }

    public void calculate_sum_of_water(){
        //zliczanie zapotrzebowania pól
        for(int i=0; i<list_of_crops.size(); i++){
            this.sum_of_water += list_of_crops.get(i).getWater_demand();
        }
        //woda dla zwierzat
        for(int i=0; i<pets_population; i++){
            this.sum_of_water += list_of_pets.get(i).getWater();
        }
        //woda dla ludzi
        for(int i=0; i<population; i++){
            this.sum_of_water += list_of_residents.get(i).getWater();
        }
    }

    public void generating_crops(){
        // tutaj pola muszą byc dodawane do listy w takiej kolejnosci w jakiej są w funkcji poniżej: cultivating_fields()
        list_of_crops.add(new Potato_crops());
        list_of_crops.add(new Apple_crops());
        list_of_crops.add(new Animal_breeding());
        list_of_crops.add(new Cucumber_crops());
        list_of_crops.add(new Tomato_crops());
        list_of_crops.add(new Wheat_crops());
    }

    public void cultivating_fields(){
        list_of_crops.get(0).calculate_crop_parameters(sum_of_potatoes);
        list_of_crops.get(1).calculate_crop_parameters(sum_of_apples);
        list_of_crops.get(2).calculate_crop_parameters(sum_of_meat);
        list_of_crops.get(3).calculate_crop_parameters(sum_of_cucumbers);
        list_of_crops.get(4).calculate_crop_parameters(sum_of_tomatoes);
        list_of_crops.get(5).calculate_crop_parameters(sum_of_wheat);
    }

}
