package duplicatenumber;
/**
 * @author syip
 * # Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 
 * 1 and n (inclusive), prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be 
 * repeated more than once.
 * 
 * Solution: Binary Search based on count of values <= mid O(log n)
 */
public class DuplicateNumber {
    public static int findDuplicate(int[] numArray) {
        int head = 1;
        int tail = numArray.length-1;
        while (head<tail) {
            int mid = (head+tail)/2;
            int smallerNums = 0;
            for (int value : numArray) {
                if (value <= mid) {
                    smallerNums++;
                }
            }
            if (smallerNums > mid) tail = mid;
            else head = mid+1;
        }
        return tail;
    }

    public static void main(String[] args) {
        assert findDuplicate(new int[] {3,4,1,2,2}) == 2;
        assert findDuplicate(new int[] {3,4,1,1,2}) == 1;
        assert findDuplicate(new int[] {3,2,1,2,2}) == 2;
        assert findDuplicate(new int[] {3,2,1,4,4}) == 4;
        assert findDuplicate(new int[] {3,2,1,4,3}) == 3;
        assert findDuplicate(new int[] {2,2,1,2,2}) == 2;
        assert findDuplicate(new int[] {3,2,1,4,5,4,6,7,8}) == 4;
    }
}
