const array1 = [2,10,30,53,99];
const array2 = [11,14,25,46,88];

// util
function median(values) {

    values.sort( function(a,b) {return a - b;} );

    var half = Math.floor(values.length/2);

    if(values.length % 2)
        return values[half];
    else
        return (values[half-1] + values[half]) / 2.0;
}

function findMedian(arr1,arr2) {
  if (arr1.length === 2 && arr2.length === 2) {
    return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1]))/2
  }
  const m1 = median(arr1);
  const m2 = median(arr2);
  
  if (m1 === m2) {
    return m1;
  }
  
  if (m1 > m2) {
    const m1Slice = arr1.slice(0, Math.floor(arr1.length/2) + 1);
    const m2Slice = arr2.slice(arr2.indexOf(m2), arr2.length);
    return findMedian(m1Slice,m2Slice);
  }
  
  if (m2 > m1) {
    const m1Slice = arr1.slice(arr1.indexOf(m1), arr1.length);
    const m2Slice = arr2.slice(0, Math.floor(arr2.length/2) + 1);
    return findMedian(m1Slice,m2Slice);
  }
}

console.log(findMedian(array1,array2));