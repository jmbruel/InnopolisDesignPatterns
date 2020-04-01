package products;

abstract public class Pizza {
    String name;

    public void prepare(){
        System.out.println("Preparing " + this.name);
    }

    public void bake(){
        System.out.println("Baking " + this.name);
    }

    public void cut(){
        System.out.println("Cutting " + this.name);
    }

    public void box(){
        System.out.println("Place pizza " + this.name + " in box");
    }

    public String getName(){
        return this.name;
    }
}

