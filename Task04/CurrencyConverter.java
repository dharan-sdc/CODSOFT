package Task04;

import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    private static final HashMap<String, Double> rates = new HashMap<>();

    static {
        rates.put("USD", 1.0);
        rates.put("EUR", 0.85);
        rates.put("GBP", 0.75);
        rates.put("INR", 74.50);
        rates.put("JPY", 110.45);
        rates.put("CAD", 1.25);
    }

    public static double convertCurrency(String base, String target, double amount) {
        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("Invalid currency selection!");
            return -1;
        }
        double baseRate = rates.get(base);
        double targetRate = rates.get(target);
        return (amount / baseRate) * targetRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available currencies: " + rates.keySet());

        System.out.print("Enter base currency (e.g., USD, EUR, GBP): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., USD, EUR, GBP): ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
        } else {
            double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
            if (convertedAmount != -1) {
                System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
            }
        }

        scanner.close();
    }
}
