function zip(arrA, arrB) {
  const result = [];
  let a = 0;
  let b = 0;

  while (arrA[a] || arrB[b]) {
    if (arrA[a] === undefined || arrB[b] < arrA[a]) result.push(arrB[b++]);
    else result.push(arrA[a++]);
  }

  return result;
}

console.log(zip([1,3,5], [2,4,6]));

function sort(arr) {
  if (arr.length === 1) return arr;

  const mid = Math.floor(arr.length / 2);

  return zip(sort(arr.slice(0, mid)), sort(arr.slice(mid)))
}

console.log(sort([1,4,5,3,6,2]));
console.log(sort([1,4,4,6,5,3,6,2]));