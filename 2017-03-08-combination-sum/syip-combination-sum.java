package combinationsum;
import java.util.*;
/**
 * @author syip
 * # Combination Sum
 * Given an integer array with all positive numbers and no duplicates, find the number 
 * of possible combinations that add up to a positive integer target.
 * Example: 
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * 
 * Solution: Dynamic programming to retrieve solution set of smaller amounts and memoization to cache solutions
 */
public class CombinationSum {

    static Map<Integer, Set<String>> COMPUTED_SOLUTIONS = new HashMap<>();

    public static Integer getCombinationListCount (int availableIntegers[], int amount) {
        clearCache();
        return getCombinationListHelper(availableIntegers, amount).size();
    }
    
    public static Set<String> getCombinationList (int availableIntegers[], int amount) {
        clearCache();
        return getCombinationListHelper(availableIntegers, amount);
    }
    
    private static Set<String> getCombinationListHelper (int availableIntegers[], int amount) {
        Set<String> solutions = new HashSet<>();

        for (int i = 0; i < availableIntegers.length; i++) {
            int intValue = availableIntegers[i];
            int newAmount = amount - intValue;
            if (newAmount < 0) continue;
            else if (newAmount == 0) {
                solutions.add(intValue + "");
            } else {
                Set<String> subSolutions;
                if (COMPUTED_SOLUTIONS.containsKey(newAmount)) {
                    subSolutions = COMPUTED_SOLUTIONS.get(newAmount);
                } else {
                    subSolutions = getCombinationList(availableIntegers, newAmount);
                }
                solutions.addAll(addIntegerToFrontOfSet(intValue, subSolutions));
            }
        }
        COMPUTED_SOLUTIONS.put(amount, solutions);
        return solutions;
    }
    
    private static Set<String> addIntegerToFrontOfSet (Integer addInteger, Set<String> solutionSet) {  
        Set<String> result = new HashSet<>();
        for (String solution : solutionSet) {
            result.add(addInteger + "," + solution);
        }
        return result;
    }
    
    private static void clearCache() { COMPUTED_SOLUTIONS = new HashMap<>(); }

    public static void main(String[] args) {

        Set<String> result = null;
        result = getCombinationList(new int[]{1,10,2}, 5);
        for (String str : result) System.out.print(str + "  ");
        System.out.println();
        result = getCombinationList(new int[]{1,2,3}, 4);
        for (String str : result) System.out.print(str + "  ");
        System.out.println();
        assert (getCombinationListCount(new int[]{1,2,3}, 4) == 7);
    }
}
