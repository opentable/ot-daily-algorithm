'use strict'

function wiggleSort(arr) {

  arr.sort()
  let mid = Math.floor(arr.length / 2)
  let low = arr.slice(0,mid)
  let high = arr.slice(mid)
  let wiggledArr = []

  for(let i=0, max=mid+1; i<=mid; i++) {
    if (low[i]) {
      wiggledArr.push(low[i])
    }
    if (high[i]) {
      wiggledArr.push(high[i])
    }
  }

  return wiggledArr

}

console.log(wiggleSort([1, 5, 1, 1, 6, 4]))
console.log(wiggleSort([1, 3, 2, 2, 3, 1]))
