import Animals.Rodent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RodnetTest {
    @Test
    public void set_food_demand_for_pets() {
        Rodent rodnet = new Rodent();

        rodnet.set_food_demand_for_pets();

        Assertions.assertNotEquals(0, rodnet.Get_food_demand_for_pets());
        Assertions.assertNotEquals(0, rodnet.getWater());
    }
}