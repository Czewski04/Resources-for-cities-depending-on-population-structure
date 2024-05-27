package Crops;

import Interfaces.Calculate_crops_parameters;

public class Animal_breeding extends Crops implements Calculate_crops_parameters {

    Animal_breeding(){
        this.area_factor = 0.5;
        this.water_factor = 10;
    }

    public void calculate_crop_parameters(double sum_of_food) {
        crop_area = area_factor * sum_of_food;
        water_demand = crop_area * water_factor;
    }
}
