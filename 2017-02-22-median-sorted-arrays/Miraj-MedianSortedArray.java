/**
 *
 * @author mshah
 */
public class MedianSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1,3,5,7,9};
        int arr2[] = {2,4,6,8,10};
        MedianSortedArray median = new MedianSortedArray();
        System.out.println("Ans: "+median.findMedian(arr1, arr2, 0, arr1.length-1, 0, arr2.length -1));
    }
    
    int findMedian(int arr1[], int arr2[], int start1, int end1, int start2, int end2) {
        
        int len1 = end1 - start1 + 1;
        int median1 = median(arr1, start1, end1);
        int median2 = median(arr2, start2, end2);
        int mid1 = start1 + (end1-start1)/2;
        int mid2 = start2 + (end2-start2)/2;
        if(median1 == median2) {
            //Both are Same return any
            return median1;
        } else if(len1 == 1) {
            //Just 1 element left, assuming both arrays are same size
            return (median1 + median2)/2;
        } else if(len1 == 2) {
            //Only 2 elements exists calculate the median by arranging the elements so max of first two will be mid1
            //Min of last 2 will be mid2
            return ((Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]))/2);
        } else if(median1>median2) {
            //Arr1: left half, Arr2: right half
            if(len1 % 2 == 0)
                return findMedian(arr1, arr2, start1, mid1, mid2+1, end2);
            return findMedian(arr1, arr2, start1, mid1-1, mid2+1, end2);
        } else {
            //Arr1: Right half, Arr2: Left half
            if(len1 % 2 == 0)
                return findMedian(arr1, arr2, mid1+1, end1, start2, mid2);
            return findMedian(arr1, arr2, mid1+1, end1, start2, mid2-1);
        }
        
    }
    
    int median(int arr1[], int start, int end) {
        int len = end - start +1;
        if(len == 1) {
            return arr1[start];
        }
        int mid = start + (end - start)/2;
        if(len%2==1) {
            //Odd array size
            return arr1[mid];
        } else {
            //Even array size
            return (arr1[mid] + arr1[mid + 1])/2;
        }
        
    }
    
}
