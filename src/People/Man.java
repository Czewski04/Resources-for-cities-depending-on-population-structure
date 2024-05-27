package People;

import Interfaces.Change_food_demand_for_people;
import Interfaces.Life;

public class Man extends Person implements Change_food_demand_for_people, Life {

    public Man(){
        this.age = (int)Math.round((Math.random()*(100-1))+1);
        if(age<10){
            this.potatoes = Math.random();
            this.apples = Math.random();
            this.bread = (Math.random()*(1.5));
            this.meat = Math.random();
            this.cucumbers = (Math.random()*(0.5));
            this.tomatoes = Math.random();
            this.water = Math.random()*(14-3.5)+3.5;
        }
        else if(age<18){
            this.potatoes = (Math.random()*(2));
            this.apples = (Math.random()*(1.5));
            this.bread = (Math.random()*(1.5));
            this.meat = (Math.random()*(2));
            this.cucumbers = (Math.random());
            this.tomatoes = Math.random();
            this.water = Math.random()*(21-7)+7;
        } else if (age < 70) {
            this.potatoes = (Math.random()*(4));
            this.apples = (Math.random()*(4));
            this.bread = (Math.random()*(3));
            this.meat = (Math.random()*(5));
            this.cucumbers = (Math.random()*2);
            this.tomatoes = Math.random()*(2);
            this.water = Math.random()*(28-7)+7;
        }
        else{
            this.potatoes = (Math.random()*(1.5));
            this.apples = (Math.random()*(1.3));
            this.bread = (Math.random()*(1.3));
            this.meat = (Math.random()*(1.5));
            this.cucumbers = (Math.random()*0.8);
            this.tomatoes = Math.random()*(0.8);
            this.water = Math.random()*(21-7)+7;
        }
    }

    public void change_food_demand(){
        if(age < 10){
            this.potatoes  = (Math.random()*(3));
            this.apples = Math.random();
            this.bread = (Math.random()*(4));
            this.meat = Math.random()*(12.5-4)+4;
            this.cucumbers = (Math.random()*(3.5));
            this.meat = Math.random();
            this.water = Math.random()*(10-3.5)+3.5;
        }
        else if(age < 18){
            this.potatoes  = (Math.random()*(3.5));
            this.apples = Math.random()*(12-3)+3;
            this.bread = (Math.random()*(6.5));
            this.meat = Math.random()*(15-3.5)+3.5;
            this.cucumbers = (Math.random()*(7));
            this.cucumbers = Math.random();
            this.water = Math.random()*(10-2)+2;
        } else if (age < 70) {
            this.potatoes  = (Math.random()*(3));
            this.apples = Math.random();
            this.bread = (Math.random()*(4));
            this.meat = Math.random()*(12.5-4)+4;
            this.cucumbers = (Math.random()*(3.5));
            this.cucumbers = Math.random();
            this.water = Math.random()*(22-6)+6;
        }
        else{
            this.potatoes  = (Math.random()*(3));
            this.apples = Math.random();
            this.bread = (Math.random()*(4));
            this.meat = Math.random();
            this.cucumbers = (Math.random()*(2.5));
            this.cucumbers = Math.random();
            this.water = Math.random()*(15-4)+4;
        }
    }


    @Override
    public void born() {

    }

    @Override
    public void death(int age) {

    }
}
