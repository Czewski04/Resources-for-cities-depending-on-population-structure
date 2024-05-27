package Crops;

import Interfaces.Calculate_crops_parameters;

public class Tomato_crops extends Crops implements Calculate_crops_parameters {
    Tomato_crops(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }

    public void calculate_crop_parameters(double sum_of_food) {
        crop_area = area_factor * sum_of_food;
        water_demand = crop_area * water_factor;
    }
}
