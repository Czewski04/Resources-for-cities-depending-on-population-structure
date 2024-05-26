public class Rodnet extends Pet implements Life{
    private double seeds;

    public Rodnet() {
        this.age = (int)Math.round((Math.random()*(20-1))+1);
        this.water = Math.random()*(0.5-0.1)+0.1;
        this.seeds = Math.random()*(0.5-0.1)+0.1;
    }

    public double getMeat(){
        return seeds;
    }

    public void change_meat_demand(double meat){

    }

    public void born(){

    }

    public void death(int age){

    }
}
