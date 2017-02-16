package productexceptself;
import java.util.*;
/**
 * @author syip
 * # Product of Array except Self
 * Given an array of n integers where n > 1, nums, return an array output such 
 * that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Solution: Passover array twice to get sub-products, left to right then from 
 * right to left, then once more to get product of both sides. O(n)
 */
public class ProductExceptSelf {
    public static int[] getProductExceptSelf(int[] numArray) {
        int length = numArray.length;
        int[] rightToLeft = new int[length];
        int[] leftToRight = new int[length];
        int[] products = new int[length];
        leftToRight[0] = 1;
        rightToLeft[length-1] = 1;
        for(int i = 0; i < length-1; i++){
            leftToRight[i+1] = numArray[i] * leftToRight[i];
        }
        for(int j = length-1; j > 0; j--) {
            rightToLeft[j-1] = numArray[j] * rightToLeft[j];
        }
        for (int k = 0; k < length; k++) {
            products[k] = leftToRight[k] * rightToLeft[k];
        }
        return products;
    }
    public static void main(String[] args) {
        assert Arrays.equals(getProductExceptSelf(new int[] {3,4,5,2,6}),(new int[]{240,180,144,360,120}));
        assert Arrays.equals(getProductExceptSelf(new int[] {0,8,5,2,6}),(new int[]{480,0,0,0,0}));
        assert Arrays.equals(getProductExceptSelf(new int[] {3,4,5,2,0}),(new int[]{0,0,0,0,120}));
        assert Arrays.equals(getProductExceptSelf(new int[] {-1,4,5,2,6}),(new int[]{240,-60,-48,-120,-40}));
        assert Arrays.equals(getProductExceptSelf(new int[] {3,4,5,2,-1}),(new int[]{-40,-30,-24,-60,120}));
        assert Arrays.equals(getProductExceptSelf(new int[] {-1,4,5,2,-1}),(new int[]{-40,10,8,20,-40}));
    }
}