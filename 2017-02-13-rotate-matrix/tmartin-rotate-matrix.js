'use strict';

function rotateMatrix(mat) {

  for(let i=0, max=mat.length; i<max; i++) {
    for(let j=i+1, max=mat.length; j<max; j++) {
      let tmp = mat[i][j]
      mat[i][j] = mat[j][i]
      mat[j][i] = tmp
    }
    mat[i].reverse()
  }

  return mat;

}

rotateMatrix([['A', 'B'], ['C', 'D']])
rotateMatrix([['A', 'B', 'C'], ['D', 'E', 'F'], ['G', 'H', 'I']])
rotateMatrix([['A', 'B', 'C', 'D'], ['E', 'F', 'G', 'H'], ['I', 'J', 'K', 'L'], ['M', 'N', 'O', 'P']])