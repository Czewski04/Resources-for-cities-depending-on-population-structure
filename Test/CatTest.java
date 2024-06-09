import Animals.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void set_food_demand_for_pets(){
        Cat cat = new Cat();

        cat.set_food_demand_for_pets();

        Assertions.assertNotEquals(0, cat.getWater());
        Assertions.assertNotEquals(0, cat.Get_food_demand_for_pets());
    }
}
