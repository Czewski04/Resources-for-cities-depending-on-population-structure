import Main.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CityTest {

    @Test
    public void born() {
        City city1 = new City("test", 1000, 1,1,1,1,1,1,1);
        City city2 = new City("test", 1000, 1,1,1,1,1,1,1);
        city1.generate_residents();
        city2.generate_residents();

        city1.born();

        Assertions.assertNotEquals(city2.getPopulation(), city1.getPopulation());
    }

    @Test
    public void death(){
        City city1 = new City("test", 1000, 100,100,100,100,1,1,1);
        City city2 = new City("test", 1000, 1,1,1,1,1,1,1);

        city1.death();

        Assertions.assertNotEquals(city2.getPopulation(), city1.getPopulation());
    }

    @Test
    public void generate_residents(){
        City city1 = new City("test", 10, 1,1,1,1,1,1,1);

        city1.generate_residents();

        Assertions.assertEquals(city1.getPopulation(), city1.getList_of_residents().size());
    }

    @Test
    public void generating_crops(){
        City city1 = new City("test", 10, 1,1,1,1,1,1,1);

        city1.generating_crops();

        Assertions.assertEquals(6, city1.getList_of_crops().size());
    }

    @Test
    public void cultivating_fields(){
        City city = new City("test", 10, 1,1,1,1,1,1,1);
        city.generate_residents();
        city.generating_crops();
        city.calcualte_sum_without_water();

        city.cultivating_fields();

        Assertions.assertNotEquals(0, city.getList_of_crops().get(0).getCrop_area());
    }

    @Test
    public void calculate_sum_without_water(){
        City city = new City("test", 100, 1,1,1,1,1,1,1);
        city.generate_residents();
        city.generating_crops();

        city.calcualte_sum_without_water();

        Assertions.assertNotEquals(0, city.getSum_of_apples());
    }

    @Test
    public void calculate_sum_of_water(){
        City city = new City("test", 100, 1,1,1,1,1,1,1);
        city.generate_residents();
        city.generating_crops();
        city.calcualte_sum_without_water();
        city.cultivating_fields();

        city.calculate_sum_of_water();

        Assertions.assertNotEquals(0,city.getSum_of_water());
    }

    @Test
    public void natural_disaster(){
        City city = new City("test", 100, 1,1,1,1,1,1,100);
        city.generate_residents();
        int before_disaster = city.getPopulation();

        city.natural_disaster();

        Assertions.assertNotEquals(before_disaster, city.getPopulation());
    }
}