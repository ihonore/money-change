/*
 * GreedyCurrencyExchange Class
 * Master 2 IOT 2024
 *
 * Honore, Gideon and Raitah
 * November 2024
 */
import java.util.*;

public class GreedyCurrencyExchange {
    private double amountToExchange;
    private List<Double> coinDenominations;
    private LinkedList<String> exchangeDetails = new LinkedList<>();

    public GreedyCurrencyExchange(List<Double> coinDenominations, double amountToExchange) {
        this.coinDenominations = new ArrayList<>(coinDenominations);
        this.amountToExchange = amountToExchange;
        calculateGreedyExchange();
    }

    private void calculateGreedyExchange() {
        coinDenominations.sort(Collections.reverseOrder());

        for (double coin : coinDenominations) {
            int numCoins = (int) Math.floor(amountToExchange / coin);
            if (numCoins > 0) {
                exchangeDetails.add(numCoins + " Coins of " + coin + " Euros");
                amountToExchange -= numCoins * coin;
            }
        }
    }

    public LinkedList<String> getExchangeResult() {
        return exchangeDetails;
    }

    public String toString() {
        return exchangeDetails.toString();
    }
}
