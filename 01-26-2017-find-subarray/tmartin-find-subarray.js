function findSubArray (arr) {

  for(let i=0, max=arr.length; i<max; i++) {
    let sum = 0

    for(let j=i, max=arr.length; j<max; j++) {
      sum += arr[j]

      if (sum === 0) {
        console.log(`There is a subarray with zero sum from index ${i} to ${j}.`)
        return true
      }
    }
  }

  console.log('There is no subarray with zero sum.')
  return false

}

findSubArray([4, 2, -3, 1, 6])
findSubArray([4, 2, 0, 1, 6])
findSubArray([-3, 2, 3, 1, 6])
