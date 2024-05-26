public class Man extends Person implements Change_food_demand_for_people, Life{

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
        else if (age>70){
            this.potatoes = (Math.random()*(1.5));
            this.apples = (Math.random()*(1.3));
            this.bread = (Math.random()*(1.3));
            this.meat = (Math.random()*(1.5));
            this.cucumbers = (Math.random()*0.8);
            this.tomatoes = Math.random()*(0.8);
            this.water = Math.random()*(21-7)+7;
        }
    }

    @Override
    public void change_apples_demand(double apples_demand) {

    }

    @Override
    public void change_cucumbers_demand(double cucumbers_demand) {

    }

    @Override
    public void change_breads_demand(double breads_demand) {

    }

    @Override
    public void change_meat_demand(double meat_demand) {

    }

    @Override
    public void change_potatoes_demand(double potatoes_demand) {

    }

    @Override
    public void change_tomatoes_demand(double tomatoes_demand) {

    }

    @Override
    public void change_water_demand(double water_demand) {

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
