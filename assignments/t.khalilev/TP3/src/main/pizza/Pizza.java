package main.pizza;

abstract public class Pizza {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cook() {
        System.out.println(name + " has been cooked");
    }

    public void cut() {
        System.out.println(name + " has been cut");
    }

    public void pack() {
        System.out.println(name + " has been packed");
    }
}
