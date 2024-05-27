package Crops;

public class Crops {
    protected double crop_area;
    protected double water_demand;
    protected double area_factor;
    protected double water_factor;

    public double getWater_demand() {
        return water_demand;
    }

    public void calculate_crop_parameters(double sum_of_food) {
        this.crop_area = area_factor * sum_of_food;
        this.water_demand = crop_area * water_factor;
    }
}
