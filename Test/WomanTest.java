import People.Man;
import People.Woman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WomanTest {
    @Test
    public void set_food_demand(){
        Woman woman = new Woman();

        woman.set_food_demand();

        Assertions.assertNotEquals(0, woman.getApples());
        Assertions.assertNotEquals(0, woman.getBread());
        Assertions.assertNotEquals(0, woman.getMeat());
        Assertions.assertNotEquals(0, woman.getCucumbers());
        Assertions.assertNotEquals(0, woman.getTomatoes());
        Assertions.assertNotEquals(0, woman.getWater());
    }
}