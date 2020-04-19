package elukyanchikovaTP3;

public abstract class Pizza {
    protected String pizzaName;
    public String getPizzaName() {
        return pizzaName;
    }
    public void prepare(){
        System.out.println(this.pizzaName+ " is being prepared to be baked.");
    }
    public void cook(){
        System.out.println(this.pizzaName +" is being cooked.");
    }
    public void pack(){
        System.out.println(this.pizzaName + " is being packed.");
    }
    public void deliver(){
        System.out.println(this.pizzaName + " is being delivered.\n"+ this.pizzaName +" is delivered.\n");
    }
}
