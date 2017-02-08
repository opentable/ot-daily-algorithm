package searchrotatedarray;
/**
 * @author syip
 * Search Rotated Array
 * Given a sorted array of n integers that has been rotated an unknown 
 * number of times, writed code to find an element in the array. You may 
 * assume that the array was orginally sorted in increasing order.
 * Ex: input: [15,16,19,20,25,1,3,4,5,7,10,14] output 8 (the index of 5 in the array)
 * 
 * Solution: Binary Search array O(log n)
 */
public class SearchRotatedArray {
	// Returns -1 if element is not found
    public static int findElementInRotatedArray(int[] numArray, int element) {
        if (numArray == null || numArray.length == 0) return -1;
        int head = 0;
        int tail = numArray.length-1;
        while (head <= tail) {
            int headValue = numArray[head];
            int tailValue = numArray[tail];
            int mid = (tail-head)/2 + head;
            int midValue = numArray[mid];
            if (midValue == element) return mid;
            if (headValue < midValue) {  //pivot is right of mid, left is ordered
                if(headValue <= element && element < midValue) tail = mid-1;  // element is in ordered left
                else head = mid+1;  //element is not in ordered left
            } else {  //pivot is left of mid, right is ordered
                if (midValue < element && element <= tailValue) head = mid+1; // element is in ordered right
                else tail = mid-1;  //element is not in ordered right
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        assert findElementInRotatedArray(new int[] {16,19,20,1,3,5,6,10},10) == 7;
        assert findElementInRotatedArray(new int[] {16,19,20,1,3,5,6,10},19) == 1;
        assert findElementInRotatedArray(new int[] {16,19,20,1,3,5,6,10},2) == -1;
        assert findElementInRotatedArray(new int[] {16,19,20,1,3,5,6,10},7) == -1;
        assert findElementInRotatedArray(new int[] {15,16,19,20,21,23,5,6},5) == 6;
        assert findElementInRotatedArray(new int[] {15,16,19,20,21,23,5,6},16) == 1;
        assert findElementInRotatedArray(new int[] {15,16,19,20,1,3,5,6,10},21) == -1;
        assert findElementInRotatedArray(new int[] {15,16,19,20,1,3,5,6,10},7) == -1;
    }   
}