#include<tuple>
#include<vector>

std::pair<int, int> elem_in_sorted_matrix(
  const std::vector<std::vector<int> >& matrix, int target
) {
  int row = 0;
  int col = matrix[0].size() - 1;
  while (row < matrix.size() && 0 <= col) {
      if (matrix[row][col] == target) return std::pair<int, int>(row, col);
      if (target < matrix[row][col]) {
        --col;
      } else if (matrix[row][col] < target) {
        ++row;
      }
  }
  return std::pair<int, int>(-1, -1);
}
