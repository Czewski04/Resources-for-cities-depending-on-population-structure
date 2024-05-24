import java.util.ArrayList;

public class City {
    private String name;
    private int population;
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
    public void generate_residents(){

    }
    public void calcualte_sum(){

    }
}
