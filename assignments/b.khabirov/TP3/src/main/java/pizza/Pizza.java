package pizza;

abstract public class Pizza {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void make() {
        System.out.println(name + " has been made");
    }

    public void cut() {
        System.out.println(name + " has been cut");
    }

    public void deliver() {
        System.out.println(name + " has been delivered");
    }
}
