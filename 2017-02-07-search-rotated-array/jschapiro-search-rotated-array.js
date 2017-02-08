function searchRotatedArray(arr, val) {
  if (!arr || val === undefined) {
    return -1;
  }

  let startIndex = 0;
  const endIndex = arr.length -1;
  
  // array has not been rotated
  if (arr[startIndex] > arr[endIndex]) {
    return arr.indexOf(val);
  }
  
  while(arr[startIndex] > arr[endIndex]) {
    startIndex = startIndex + 1;
  }
  
  return arr.indexOf(val) + startIndex;
}

console.log(searchRotatedArray([15,16,19,20,25,1,3,4,5,7,10,14], 5)) // 8