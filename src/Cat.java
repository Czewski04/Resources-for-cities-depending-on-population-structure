public class Cat extends Pet implements Life {
    private double meat;

    public Cat() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(2-0.5)+0.5;
        this.meat = Math.random()*(1-0.2)+0.2;
    }

    public double Get_food_demand_for_pets(){
        return meat;
    }

    public void change_meat_demand(double meat){

    }

    public void born(){

    }

    public void death(int age){

    }
}
