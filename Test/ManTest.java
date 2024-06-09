import People.Man;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManTest {
    @Test
    public void set_food_demand(){
        Man man = new Man();

        man.set_food_demand();

        Assertions.assertNotEquals(0, man.getApples());
        Assertions.assertNotEquals(0, man.getBread());
        Assertions.assertNotEquals(0, man.getMeat());
        Assertions.assertNotEquals(0, man.getCucumbers());
        Assertions.assertNotEquals(0, man.getTomatoes());
        Assertions.assertNotEquals(0, man.getWater());
    }
}
