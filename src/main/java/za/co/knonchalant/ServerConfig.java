package za.co.knonchalant;

public class ServerConfig {
    private static boolean production;

    static {
        String production1 = System.getProperty("production");
        production = production1 != null && production1.toLowerCase().equals("true");

        System.out.println("**************************************");
        System.out.println("*            CanDoHelloBot           *");
        System.out.println("*  Server configuration:             *");
        System.out.println("*                                    *");
        System.out.println(String.format("*       Production: %s              *", production ? "Yes" : "No "));
        System.out.println("**************************************");
    }

    public static boolean isProduction() {
        return production;
    }

    public static boolean isTest() {
        return !production;
    }
}
