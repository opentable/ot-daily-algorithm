public class UtkarshSengarMatrixSearch {
    public static void main(String[] args){
        int[][] matrix = { {0, 1, 2, 3} , {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 42}};
        int val = 6;
        boolean exists = searchMat(matrix, val);
        System.out.println(exists);
    }

    private static boolean searchMat(int[][] matrix, int val) {
        int low = 0;
        int high = matrix.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int sLow =  0;
            int sHigh = matrix[mid].length - 1;

            while(sLow <= sHigh){
                int sMid = sLow + (sHigh - sLow)/2;
                if(val < matrix[mid][sMid]){
                    sHigh = sMid - 1;
                    high = mid - 1;
                } else if(val > matrix[mid][sMid]){
                    sLow = sMid + 1;
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}