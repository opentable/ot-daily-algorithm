function mergeSort(arr){
  if (!arr || arr.length <=1) {
    return arr;
  }
  
  const midPoint = Math.floor(arr.length/2);
  const left = arr.slice(0, midPoint);
  const right = arr.slice(midPoint, arr.length);

  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  let lPtr = 0;
  let rPtr = 0;
  const results = [];
  
  // merge what we can on first pass
  while(left.length && right.length) {
   if (left[0] > right[0]) {
     results.push(right[0]);
     right = right.slice(1, right.length);
   } else {
     results.push(left[0]);
     left = left.slice(1, left.length);
   }
  }
  
  // handle left overs
  while(left.length) {
    results.push(left[0]);
    left = left.slice(1, left.length);
  }
  
  // handle left overs
  while(right.length) {
    results.push(right[0]);
     right = right.slice(1, right.length);
  }

  return results;
}

console.log(mergeSort([4,5,6,7,0,1,2,3]))


