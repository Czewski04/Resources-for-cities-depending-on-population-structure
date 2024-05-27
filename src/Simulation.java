public class Simulation {
    double time;

    public void show_crop_area(double area){

    }

    public void show_water_demand(double demand){

    }

    public void show_food_demand(double demand){

    }

    public void time_progress(double time){
        this.time += 1;
    }

    public static void main(String[] args) {
        Simulation s = new Simulation();
        City c1 = new City("Wroclaw", 200);
        c1.generate_residents();
        System.out.println("liczba ludności " + c1.getList_of_residents().size());
        System.out.println("liczba zwirzat " + c1.getList_of_pets().size());
        c1.calcualte_sum();
        System.out.println("apples "+ c1.getSum_of_apples());
        System.out.println("potatoes "+ c1.getSum_of_potatoes());
        System.out.println("breads " + c1.getSum_of_bread());
        System.out.println("cucumbers " + c1.getSum_of_cucumbers());
        System.out.println("tomatoes " + c1.getSum_of_tomatoes());
        System.out.println("meat " + c1.getSum_of_meat());
        System.out.println("water " + c1.getSum_of_water());
        System.out.println("seeds " + c1.getSum_of_seeds());
    }
}
