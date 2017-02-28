function swap(arr, first, second) {
  const temp = arr[first];
  arr[first] = arr[second];
  arr[second] = temp;
  return arr;  
}

function partition(arr, low, high) {
  let pivot = arr[low];
  let i = low - 1;
  
  for (let j = low; j <= high; j ++) {
    if (arr[j] <= pivot) {
      i ++;
      arr = swap(arr, i, j);
    }
  }

  arr = swap(arr, i, low);
  return i;
}

function quickSort(arr, low, high) {
  if (low === undefined && high === undefined) {
    low = 0;
    high = arr.length-1;
  }
  if (low < high)
    {
      let pi = partitionLow(arr, low, high);
      arr = quickSort(arr, low, pi - 1);  // Before pi
      arr = quickSort(arr, pi + 1, high); // After pi
    }
    return arr;
}
