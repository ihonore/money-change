/*
 * ExhaustiveCalculator Class
 * Master 2 IOT 2024
 *
 * Honore, Gideon and Raitah
 * November 2024
 */
import java.util.*;

public class ExhaustiveCalculator {
    private double targetAmount;
    private List<Double> coinDenominations;
    private LinkedList<Double> currentCombination = new LinkedList<>();
    private List<List<Double>> allSolutions = new ArrayList<>();
    private List<Double> bestSolution = null;
    private int minCoins = Integer.MAX_VALUE;
    private Map<Double, Integer> memoization = new HashMap<>();

    public ExhaustiveCalculator(List<Double> coinDenominations, double targetAmount) {
        this.coinDenominations = new ArrayList<>(coinDenominations);
        this.targetAmount = targetAmount;
        calculateAllPossibilities();
    }

    private void calculateAllPossibilities() {
        findCombinations(targetAmount, 0);
    }

    private void findCombinations(double remainingAmount, int index) {
        if (remainingAmount == 0) {
            allSolutions.add(new ArrayList<>(currentCombination));
            checkAndUpdateBestSolution(new ArrayList<>(currentCombination));
            return;
        }

        if (remainingAmount < 0 || index >= coinDenominations.size()) {
            return;
        }

        for (int count = 0; count <= (int) (remainingAmount / coinDenominations.get(index)); count++) {
            for (int j = 0; j < count; j++) {
                currentCombination.add(coinDenominations.get(index));
            }
            findCombinations(remainingAmount - count * coinDenominations.get(index), index + 1);
            for (int j = 0; j < count; j++) {
                currentCombination.removeLast();
            }
        }
    }

    private void checkAndUpdateBestSolution(List<Double> solution) {
        int coinCount = solution.size();
        if (coinCount < minCoins) {
            minCoins = coinCount;
            bestSolution = solution;
            System.out.println("New best solution: " + bestSolution + " with " + minCoins + " coins.");
        }
    }

    // Optimized method to use cut, price, and share
    public List<Double> calculateBestSolutionWithCutAndShare() {
        minCoins = Integer.MAX_VALUE;
        bestSolution = null;
        memoization.clear();
        findBestSolutionWithCutAndShare(targetAmount, 0, new LinkedList<>());
        return bestSolution;
    }

    private void findBestSolutionWithCutAndShare(double remainingAmount, int currentCoins, LinkedList<Double> currentSolution) {
        if (remainingAmount == 0) {
            if (currentCoins < minCoins) {
                minCoins = currentCoins;
                bestSolution = new ArrayList<>(currentSolution);
                System.out.println("New best solution (with cut & share): " + bestSolution + " using " + minCoins + " coins.");
            }
            return;
        }

        if (remainingAmount < 0 || currentCoins >= minCoins) {
            return;
        }

        if (memoization.containsKey(remainingAmount) && memoization.get(remainingAmount) <= currentCoins) {
            return;
        }

        memoization.put(remainingAmount, currentCoins);

        for (double coin : coinDenominations) {
            currentSolution.add(coin);
            findBestSolutionWithCutAndShare(remainingAmount - coin, currentCoins + 1, currentSolution);
            currentSolution.removeLast();
        }
    }

    public List<List<Double>> getAllPossibilities() {
        return allSolutions;
    }

    public List<Double> getBestSolution() {
        return bestSolution;
    }
}
