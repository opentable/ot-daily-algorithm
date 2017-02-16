function productUpToPoint(arr) {
  let product = 1;

  return arr.map((val, i) => {
    const previousProduct = product;
    product = product * val;
    return previousProduct;
  })
}

function productAfterPoint(arr) {
  // Horrible js mutability nonsense alert
  return productUpToPoint(arr.reverse()).reverse();
}

function multiplyArrays(arrA, arrB) {
  return arrA.map((val, i) => val * arrB[i]);
}

function productExceptSelf(arr) {
  return multiplyArrays(productUpToPoint(arr), productAfterPoint(arr));
}

console.log(productExceptSelf([1, 2, 3, 4])); // [24, 12, 8, 6]