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
    private List<Double> exchangeDetails = new ArrayList<>();

    public GreedyCurrencyExchange(List<Double> coinDenominations, double amountToExchange) {
        this.coinDenominations = new ArrayList<>(coinDenominations);
        this.amountToExchange = amountToExchange;
        calculateGreedyExchange();
    }

    private void calculateGreedyExchange() {
        coinDenominations.sort(Collections.reverseOrder());

        for (double coin : coinDenominations) {
            int numCoins = (int) Math.floor(amountToExchange / coin);
            for (int i = 0; i < numCoins; i++) {
                exchangeDetails.add(coin);  // Add each coin individually
            }
            amountToExchange -= numCoins * coin;
        }
    }

    public List<Double> getExchangeResult() {
        return exchangeDetails;
    }

    public String toString() {
        return exchangeDetails.toString();
    }
}
