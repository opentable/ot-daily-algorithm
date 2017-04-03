package coinchange;
import java.util.*;
/**
 * @author syip
 * Coin Change
 * How many different ways can you make change for an amount, given a list of coins? 
 * In this problem, your code will need to efficiently compute the answer.
 * Write a program that, given the amount to make change for and the number of types 
 * of infinitely available coins prints out how many different ways you can make change from the coins to STDOUT.
 * 
 * Solution: Dynamic programming to retrieve solution set of smaller amounts and memoization to cache solutions
 */
public class CoinChange {

    static Map<Integer, Set<String>> COIN_SOLUTIONS = new HashMap<>();
    
    public static Set<String> getCoinChangeList(int availableCoinTypes[], int amount) {
        clearCache();
        return getCoinChangeListHelper(availableCoinTypes, amount);
    }
    
    private static Set<String> getCoinChangeListHelper(int availableCoinTypes[], int amount) {
        Set<String> solutions = new HashSet<>();
        int coinTypeCount = availableCoinTypes.length;

        for (int i = 0; i < coinTypeCount; i++) {
            int coinValue = availableCoinTypes[i];
            int newAmount = amount - coinValue;
            if (newAmount < 0) continue;
            else if (newAmount == 0) {
                String[] firstCoin = new String[coinTypeCount];
                Arrays.fill(firstCoin, "0");
                firstCoin[i] = "1";
                solutions.add(convertArrayToString(firstCoin));
            } else {
                Set<String> subSolutions;
                if (COIN_SOLUTIONS.containsKey(newAmount)) {
                    subSolutions = COIN_SOLUTIONS.get(newAmount);
                } else {
                    subSolutions = getCoinChangeListHelper(availableCoinTypes, newAmount);
                }
                solutions.addAll(addCoinToSet(i, subSolutions));
            }
        }
        COIN_SOLUTIONS.put(amount, solutions);
        return solutions;
    }
    
    private static Set<String> addCoinToSet(int coinIndex, Set<String> selectedCoinsSets) {
        Set<String> result = new HashSet<>();
        for (String selectedCoins : selectedCoinsSets) {
            String[] coins = selectedCoins.split(",");
            int coinCount = Integer.parseInt(coins[coinIndex]);
            coins[coinIndex] = ++coinCount + "";
            result.add(convertArrayToString(coins));
        }
        return result;
    }
    
    private static String convertArrayToString(String[] stringList) {
        StringJoiner sj = new StringJoiner(",");
        for (String str : stringList) sj.add(str);
        return sj.toString();
    }
    
    private static void clearCache() { COIN_SOLUTIONS = new HashMap<>(); }
    
    public static void main(String[] args) {
        
        Set<String> result = null;
        result = getCoinChangeList(new int[]{1,10,2}, 5);
        for (String str : result) System.out.print(str + "  ");
        System.out.println();
        result = getCoinChangeList(new int[]{2,4,7}, 11);
        for (String str : result) System.out.print(str + "  ");
    }
}
