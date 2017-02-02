public class SortedMatrixSearcher
   {
       public static bool Search(int[,] matrix, int k)
       {
           var rowLength = matrix.GetLength(0);
           var colLength = matrix.GetLength(1);

           var row = 0;
           var col = colLength - 1;

           while (row <= (rowLength - 1) && col >= 0)
           {
               if (k < matrix[row, col])
               {
                   col = col - 1;
               }
               else if (k > matrix[row, col])
               {
                   row = row + 1;
               }
               else
               {
                   return true;
               }
           }

           return false;

       }
   }
