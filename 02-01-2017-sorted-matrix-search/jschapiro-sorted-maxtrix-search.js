function closenessToTarget(k, row, col){
  if (k === row || k > row && Math.abs(k - row) < Math.abs(k -col)) {
    return 'row';
  }
  
  if (k === col || k > col && Math.abs(k - col) < Math.abs(k -row)){
    return 'col';
  }
  
  return 'both';
}

function matrixSearch(matrix, k, row, col) {
  if (col === undefined || row === undefined) {
    col = 0;
    row = 0;
  }
  
  if (matrix[col] === undefined || matrix[col][row]===undefined) {
   return false; 
  }
  
  const currentVal = matrix[col][row];

  if (k === currentVal) { 
    return true; 
    
  }

  const nextRow = row+1 < matrix.length ? matrix[col][row+1] : -1;
  const nextCol = col+1 < matrix.length ? matrix[col+1][row] : -1;
  
  if (k < nextRow && k < nextCol) {
    return false;
  }
  const directionToMove = 
    closenessToTarget(k, nextRow, nextCol);

 
 if (directionToMove === 'row') {
   return matrixSearch(matrix, k, ++row, col);
 }
 
 if (directionToMove === 'col') {
   return matrixSearch(matrix, k, row, ++col);
 }

 return matrixSearch(matrix, k, ++row, col) || matrixSearch(matrix, k, row, ++col);
}
