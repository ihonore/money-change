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

    private static String greedySolution;
    private static double greedyTime;
    private static String exhaustiveSolution;
    private static double exhaustiveTime;
    private static String cutPriceShareSolution;
    private static double cutPriceShareTime;

    public static void main(String[] args) {
        double amountToExchange = 6.5;
        List<Double> coinDenominations = Arrays.asList(5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05);

        // Run each approach independently
        System.out.println("Greedy Currency Exchange:");
        runGreedyApproach(coinDenominations, amountToExchange);

        System.out.println("\nExhaustive Dynamic Programming Approach:");
        runExhaustiveApproach(coinDenominations, amountToExchange);

        System.out.println("\nDynamic Cut, Price, and Share Approach:");
        runCutPriceShareApproach(coinDenominations, amountToExchange);

        // Display the summary table
        displaySummaryTable();
    }

    private static void runGreedyApproach(List<Double> coinDenominations, double amount) {
        long startTime = System.nanoTime();

        GreedyCurrencyExchange greedyExchange = new GreedyCurrencyExchange(coinDenominations, amount);
        greedySolution = formatSolution(greedyExchange.getExchangeResult());

        long endTime = System.nanoTime();
        greedyTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Solution: " + greedySolution);
        System.out.println("Computation Time: " + greedyTime + " ms");
    }

    private static void runExhaustiveApproach(List<Double> coinDenominations, double amount) {
        long startTime = System.nanoTime();

        ExhaustiveCalculator exhaustiveCalculator = new ExhaustiveCalculator(coinDenominations, amount);
        exhaustiveSolution = formatSolution(exhaustiveCalculator.getBestSolution());

        long endTime = System.nanoTime();
        exhaustiveTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Solution: " + exhaustiveSolution);
        System.out.println("Computation Time: " + exhaustiveTime + " ms");
    }

    private static void runCutPriceShareApproach(List<Double> coinDenominations, double amount) {
        long startTime = System.nanoTime();

        ExhaustiveCalculator exhaustiveCalculator = new ExhaustiveCalculator(coinDenominations, amount);
        List<Double> bestSolution = exhaustiveCalculator.calculateBestSolutionWithCutAndShare();
        cutPriceShareSolution = formatSolution(bestSolution);

        long endTime = System.nanoTime();
        cutPriceShareTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Solution: " + cutPriceShareSolution);
        System.out.println("Computation Time: " + cutPriceShareTime + " ms");
    }

    private static void displaySummaryTable() {
        System.out.println("\nSummary of All Approaches:");
        System.out.printf("%-30s\t%-60s\t%-20s%n", "Approach", "Solution", "Computation Time (ms)");
        System.out.println("=".repeat(130));

        System.out.printf("%-30s\t%-60s\t%-20.4f%n", "Greedy Approach", greedySolution, greedyTime);
        System.out.println("-".repeat(130));
        System.out.printf("%-30s\t%-60s\t%-20.4f%n", "Exhaustive Approach", exhaustiveSolution, exhaustiveTime);
        System.out.println("-".repeat(130));
        System.out.printf("%-30s\t%-60s\t%-20.4f%n", "Cut, Price, and Share Approach", cutPriceShareSolution, cutPriceShareTime);
        System.out.println("=".repeat(130));
    }

    // Method to format solution for readability
    private static String formatSolution(List<Double> solution) {
        if (solution == null || solution.isEmpty()) return "No solution found";

        StringBuilder formatted = new StringBuilder();
        solution.stream().distinct().forEach(coin -> {
            long count = solution.stream().filter(c -> c.equals(coin)).count();
            formatted.append(count).append(" Coins of ").append(coin).append(" Euros, ");
        });

        return formatted.substring(0, formatted.length() - 2); // Remove trailing comma and space
    }
}
