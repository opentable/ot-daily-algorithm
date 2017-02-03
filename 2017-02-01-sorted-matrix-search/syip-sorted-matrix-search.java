package sortedmatrixsearch;

import java.awt.Point;

/**
 * @author syip
 * Given an M x N matrix in which each row and each column is sorted in 
 * ascending order, write a method to find an element.
 *
 * ex: Find 6
 *
 * 0 1 2 3
 * 4 5 6 7
 * 8 9 10 11
 * 
 * Solution: Binary Search O(log n)
 */

public class SortedMatrixSearch {
    
    /**
     * Returns Point(-1,-1) if the searchElement is not found, Points are given
     * in X (column) and Y(row) coordinates starting at index 1
     */
    public static Point findElement (int[][] integerMatrix, int searchElement) {
        
        int maxHeight = integerMatrix.length;
        int maxLength = integerMatrix[0].length;
        int tail = maxHeight*maxLength - 1;
        int head = 0;
                
        while (head <= tail) { 
            int mid = (head + tail) / 2;
            int midPointY = mid/maxLength;
            int midPointX = mid%maxLength;
            int value = integerMatrix[midPointY][midPointX];
            
            if(value == searchElement) return new Point(midPointX+1, midPointY+1);
            else if(value < searchElement) {
                head = mid + 1;
            }
            else if (value > searchElement) {
                tail = mid - 1;
            }
        }
        return new Point(-1, -1);
    }

    public static void main(String[] args) {
        int[][] matrix = { {0, 1, 2, 3} , {4, 5, 7, 8}, {9, 10, 11, 12}};
        Point p = findElement(matrix, 0);
        assert p.getX()==1;
        assert p.getY()==1;
        System.out.println("0 = " + p);

        p = findElement(matrix, 12);
        assert p.getX()==4;
        assert p.getY()==3;
        System.out.println("8 = " + p);

        
        p = findElement(matrix, 8);
        assert p.getX()==4;
        assert p.getY()==2;
        System.out.println("8 = " + p);
        
        p = findElement(matrix, 6);
        assert p.getX()==-1;
        assert p.getY()==-1;
        System.out.println("6 = " + p);
        
        p = findElement(matrix, 13);
        assert p.getX()==-1;
        assert p.getY()==-1;
        System.out.println("13 = " + p);

        p = findElement(matrix, -1);
        assert p.getX()==-1;
        assert p.getY()==-1;
        System.out.println("-1 = " + p);
    }
}
