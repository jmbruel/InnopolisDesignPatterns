public class StrasbourgPizzaFromage extends Pizza {
    public StrasbourgPizzaFromage() {
        nom = "Strasbourg pizza du fromage";
        pate = "Pâte fine";
        sauce = "Marinara sauce";

        garnitures.add("Mozzarella en lamelles");
    }

    public void couper() {
        System.out.println("Découpage en parts carrées");
    }
}
