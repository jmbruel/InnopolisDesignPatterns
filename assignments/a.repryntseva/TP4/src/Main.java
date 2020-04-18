import application.BankAgencyApplicationContext;

public class Main {
    public static void main(String[] args) {
        BankAgencyApplicationContext context = BankAgencyApplicationContext.getInstance();
        try {
            BankAgencyApplicationContext.generateMenu().execute(context);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
