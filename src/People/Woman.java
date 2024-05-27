package People;

import Interfaces.Change_food_demand_for_people;
import Interfaces.Life;

public class Woman extends Person implements Change_food_demand_for_people, Life {

    public Woman(){
        this.age = (int)Math.round((Math.random()*(100-1))+1);
        if(age < 10){
            this.potatoes = Math.random();
            this.apples = Math.random();
            this.bread = (Math.random()*(1.5));
            this.meat = Math.random();
            this.cucumbers = (Math.random()*(0.5));
            this.tomatoes = Math.random();
            this.water = Math.random()*(14-3.5)+3.5;
        }
        else if(age < 18){
            this.potatoes = (Math.random()*(1.9));
            this.apples = (Math.random()*(1.4));
            this.bread = (Math.random()*(1.3));
            this.meat = (Math.random()*(1.5));
            this.cucumbers = (Math.random()*0.8);
            this.tomatoes = Math.random()*0.8;
            this.water = Math.random()*(21-7)+7;
        } else if (age < 70) {
            this.potatoes = (Math.random()*(3.8));
            this.apples = (Math.random()*(3.8));
            this.bread = (Math.random()*(2.8));
            this.meat = (Math.random()*(3));
            this.cucumbers = (Math.random()*1.8);
            this.tomatoes = Math.random()*(1.6);
            this.water = Math.random()*(28-7)+7;
        }
        else if (age >= 70){
            this.potatoes = (Math.random()*(1.2));
            this.apples = (Math.random());
            this.bread = (Math.random()*(1.1));
            this.meat = (Math.random()*(1.1));
            this.cucumbers = (Math.random()*0.6);
            this.tomatoes = Math.random()*(0.5);
            this.water = Math.random()*(21-7)+7;
        }
    }

    public void change_food_demand(double potatoes_demand, double apples_demand, double bread_demand, double cucumbers_demand, double tomatoes_demand, double meat_demand, double water_demand){
        this.age = (int)Math.round((Math.random()*(100-1))+1);
        if(age < 10){
            potatoes_demand  = (Math.random()*(3));
            apples_demand = Math.random();
            bread_demand = (Math.random()*(4));
            meat_demand = Math.random()*(12.5-4)+4;
            cucumbers_demand = (Math.random()*(3.5));
            tomatoes_demand = Math.random();
            water_demand = Math.random()*(10-3.5)+3.5;
        }
        else if(age < 18){
            potatoes_demand  = (Math.random()*(3.5));
            apples_demand = Math.random()*(12-3)+3;
            bread_demand = (Math.random()*(6.5));
            meat_demand = Math.random()*(15-3.5)+3.5;
            cucumbers_demand = (Math.random()*(7));
            tomatoes_demand = Math.random();
            water_demand = Math.random()*(10-2)+2;
        } else if (age < 70) {
            potatoes_demand  = (Math.random()*(3));
            apples_demand = Math.random();
            bread_demand = (Math.random()*(4));
            meat_demand = Math.random()*(12.5-4)+4;
            cucumbers_demand = (Math.random()*(3.5));
            tomatoes_demand = Math.random();
            water_demand = Math.random()*(22-6)+6;
        }
        else if (age >=70){
            potatoes_demand  = (Math.random()*(3));
            apples_demand = Math.random();
            bread_demand = (Math.random()*(4));
            meat_demand = Math.random();
            cucumbers_demand = (Math.random()*(2.5));
            tomatoes_demand = Math.random();
            water_demand = Math.random()*(15-4)+4;
        }
    }


    @Override
    public void add_age() {
        super.add_age();
    }

    @Override
    public void born() {

    }

    @Override
    public void death(int age) {

    }
}
