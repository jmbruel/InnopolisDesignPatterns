package main.pizza;

abstract public class Pizza {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.println(name + " has been prepared");
    }

    public void cut() {
        System.out.println(name + " has been cut");
    }

    public void deliver() {
        System.out.println(name + " has been delivered");
    }
}