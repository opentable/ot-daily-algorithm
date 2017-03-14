function productExceptSelf(array) {
  var n = array.length;
  var product = new Array(n).fill(1);

  for (var i = 0; i < n; i++) {
    for (var j = 0; j < n; j++) {
      if (i !== j) {
        product[j] = product[j] * array[i];
      }
    }
  }

  return product;
}
