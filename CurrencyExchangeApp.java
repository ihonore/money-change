/*
 * CurrencyExchangeApp Class
 * Master 2 IOT 2024
 *
 * Honore, Gideon and Raitah
 * November 2024
 */
import java.util.Arrays;
import java.util.List;

public class CurrencyExchangeApp {

    public static void main(String[] args) {
        double amountToExchange = 12.35;
        List<Double> coinDenominations = Arrays.asList(5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05);

//        // Run Greedy Approach with Computation Time
//        System.out.println("\nGreedy Currency Exchange");
//        runGreedyApproach(coinDenominations, amountToExchange);

        // Run Dynamic Programming Exhaustive Approach with Computation Time
        System.out.println("\nCalculating All Possibilities");
        runExhaustiveApproach(coinDenominations, amountToExchange);

//        // Run Dynamic Cut, Price, and Share Approach with Computation Time
//        System.out.println("\nDynamic Cut, Price, and Share Approach");
//        runCutPriceShareApproach(coinDenominations, amountToExchange);
    }

    private static void runGreedyApproach(List<Double> coinDenominations, double amount) {
        long startTime = System.nanoTime();

        GreedyCurrencyExchange greedyExchange = new GreedyCurrencyExchange(coinDenominations, amount);
        System.out.println(greedyExchange.getExchangeResult());

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Greedy approach computation time: " + duration / 1_000_000.0 + " ms");
    }

    private static void runExhaustiveApproach(List<Double> coinDenominations, double amount) {
        long startTime = System.nanoTime();

        ExhaustiveCalculator exhaustiveCalculator = new ExhaustiveCalculator(coinDenominations, amount);
        exhaustiveCalculator.getAllPossibilities().forEach(System.out::println);
        System.out.println("\nBest solution (exhaustive): " + exhaustiveCalculator.getBestSolution());

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Exhaustive approach computation time: " + duration / 1_000_000.0 + " ms");
    }

    private static void runCutPriceShareApproach(List<Double> coinDenominations, double amount) {
        long startTime = System.nanoTime();

        ExhaustiveCalculator exhaustiveCalculator = new ExhaustiveCalculator(coinDenominations, amount);
        List<Double> bestSolution = exhaustiveCalculator.calculateBestSolutionWithCutAndShare();
        System.out.println("Best solution (cut, price, and share): " + bestSolution);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Cut, price, and share approach computation time: " + duration / 1_000_000.0 + " ms");
    }
}
