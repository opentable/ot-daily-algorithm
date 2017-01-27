function subZero(arr){
  if (!arr || !arr.length) { return false; }
  
  let currSum = 0;

  for (var i = 0; i < arr.length; i ++) {
    currSum = arr[i];
    if (currSum === 0) { return true; }
    for (var j = i + 1; j < arr.length; j++) {
      currSum += arr[j];
      if (currSum === 0) { return true; }
    }
  }

  return false;
}

// subZero([-1,3,5,-2, 2]) true
// subZero([0]) true
// subZero([1,1,-1,-1]) true
// subZero([1,1,1,-1,-1]) true
// subZero([1,2,-1]) false
// subZero([1,2,1,-5,-1]) false