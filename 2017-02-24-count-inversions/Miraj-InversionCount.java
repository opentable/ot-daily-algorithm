
/**
 *
 * @author mshah
 */
public class InversionCount {
    static int inversionCount = 0;
    public static void main(String[] args) {
        InversionCount ic = new InversionCount();
        int arr[] = {2, 4, 1, 3, 5};
        ic.mergeSort(arr, 0, arr.length-1);
        ic.printArr(arr);
        System.out.println("Inversion Count:" + inversionCount);
    }
    
    void mergeSort(int arr[], int left, int end) {
        int len = end-left+1;
        if(len == 1) {
            return;
        }
        int mid = left + (end-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, left, mid, end);
        
    }
    
    void merge(int arr[], int left, int mid, int end) {
        int leftarr[] = new int[mid-left+1];
        int rightarr[] = new int[end-mid];
        
        System.arraycopy(arr, left, leftarr, 0, mid-left+1);
        System.arraycopy(arr, mid+1, rightarr, 0, end-mid);
        
        int leftptr = 0;
        int rightptr = 0;
        int index = left;
        while(leftptr<leftarr.length && rightptr<rightarr.length) {
            if(leftarr[leftptr]<rightarr[rightptr]) {
                //Copy element from lefthalf
                arr[index++] = leftarr[leftptr++];
            } else {
                //Copy element from right half
                //Since right half is smaller it seems unsorted
                //Get the count of remaining elements from lefthalf array
                inversionCount += (mid-left);
                arr[index++] = rightarr[rightptr++];                
            }
        }
        
        while(leftptr<leftarr.length) {
            arr[index++] = leftarr[leftptr++];
        }
        
        while(rightptr<rightarr.length) {
            arr[index++] = rightarr[rightptr++];
        }
    }
    
    void printArr(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(" "+ arr[i]);
        }
    }
    
}
