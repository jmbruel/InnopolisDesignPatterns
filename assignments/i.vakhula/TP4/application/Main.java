package application;

public class Main {

    public static void main(String[] args) {
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        try {
            new StartActionsPack().getStartActions().execute(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}