import Animals.Dog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DogTest {
    @Test
    public void set_food_demand_for_pets(){
        Dog dog = new Dog();

        dog.set_food_demand_for_pets();

        Assertions.assertNotEquals(0, dog.getWater());
        Assertions.assertNotEquals(0, dog.Get_food_demand_for_pets());
    }
}
