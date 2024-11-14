# Money Change Algorithms

## Overview

This project implements and compares three different approaches to solve the coin change problem:

1. **Greedy Approach** - Quickly selects the largest possible coins until the target amount is reached.
2. **Dynamic Programming Approach** - Computes all possible solutions, printing each new best solution as it is found, and displays the best solution at the end.
3. **Dynamic Cut, Price, and Share Approach** - An optimized dynamic programming solution that balances accuracy and efficiency by leveraging pruning (cut), cost minimization (price), and memoization (share).

The objective is to achieve the target amount with the minimum number of coins using various strategies and evaluate each method's performance in terms of solution quality and computation time.

## Project Structure

- **`CurrencyExchangeApp.java`**: Main entry point for executing and comparing all approaches. Outputs individual results for each approach and a summary table of solutions and computation times.
- **`GreedyCurrencyExchange.java`**: Implements the Greedy Approach.
- **`ExhaustiveCalculator.java`**: Contains both the Dynamic Programming and Dynamic Cut, Price, and Share approaches.

## Requirements

- **Java JDK** 8 or higher
- **IntelliJ IDEA** or any Java-compatible IDE (optional but recommended)

## Installation and Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/ihonore/money-change.git
   cd money-change
   ```

## Running the Project

### Open in IntelliJ IDEA (or other IDE):

1. **Open IntelliJ IDEA.**
2. Select **File > Open...** and navigate to the cloned repository.
3. Ensure the SDK is set up correctly under **Project Structure > Project SDK**.

### Compile and Run:

1. In the `src` directory, open **`CurrencyExchangeApp.java`**.
2. Right-click on `CurrencyExchangeApp.java` and select **Run 'CurrencyExchangeApp.main()'** to execute the program.
3. This will output solutions and computation times for each approach and display a summary table at the end.

### Running the Program from the Command Line

To run the program from the command line, navigate to the `src` directory, compile the files, and then execute `CurrencyExchangeApp`:

```bash
# Navigate to the src directory
cd src

# Compile all Java files
javac *.java

# Run the main application
java CurrencyExchangeApp
```

### Modifying Inputs

To test different amounts and coin denominations, you can modify the input values in `CurrencyExchangeApp.java`:

```java
double amountToExchange = 12.35;
List<Double> coinDenominations = Arrays.asList(5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05);
```

- `amountToExchange`: Change this value to set a different target amount for exchange.
- `coinDenominations`: Modify this list to use different coin denominations for testing.

---

## How the Project Works

### Greedy Approach:

- Uses an ordered or unordered list of coins.
- Selects the largest denomination possible repeatedly until reaching the target amount.
- Fast but does not guarantee an optimal solution for all coin combinations.

### Dynamic Programming Approach:

- Computes all possible solutions by recursively trying every coin combination.
- Displays each new best solution found during computation and finally prints the best solution.
- Guarantees optimality but can be slow for large amounts and finer denominations.

### Dynamic Cut, Price, and Share Approach:

- Optimizes the Dynamic Programming Approach using:
  - **Cut**: Prunes paths that exceed known best solutions.
  - **Price**: Focuses on minimizing coin count.
  - **Share**: Reuses solutions for subproblems through memoization.
- Balances solution accuracy and computational efficiency, providing an optimal solution with reduced complexity.
