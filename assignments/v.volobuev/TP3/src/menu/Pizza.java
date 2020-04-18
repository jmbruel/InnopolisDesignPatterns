package menu;

abstract public class Pizza {
    String name;

    public void bake(){
        System.out.println("Baking " + this.getName());
    }

    public void slice(){
        System.out.println("Slicing " + this.getName());
        System.out.println(this.getName() + " ready!");
    }

    public String getName(){
        return this.name + " pizza";
    }
}

