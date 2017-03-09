
function swap(arr, idx1, idx2) {
  const tmp = arr[idx1];
  arr[idx1] = arr[idx2];
  arr[idx2] = tmp;
}

function median3(n1, n2, n3) {
    var _min = Math.min(n1, n2, n3);
    var _max = Math.max(n1, n2, n3);
    return n1 + n2 + n3 - _min - _max;
}
//
// protecting against pre-sorted arrays
//
function pivot(arr, lo, hi) {
  med_idx = ((lo + hi)/2) >> 0; // integer index
  return median3(arr[lo], arr[hi], arr[med_idx]);
}

//
// protecting against blobs of same values
//
function fat_partition(arr, pivot, lo, hi) {
  var i = lo - 1;
  var j = hi + 1;

  while (true) {
    do { i++; } while (arr[i] < pivot)
    do { j--; } while (arr[j] > pivot)

    if (i >= j) {
      // normally, we would just return 'j' at this point
      // by we want to implement "fat" partition
      // to protect against blobs of same values
      i = j;
      while (arr[i] == pivot && i > lo) { i--; }
      while (arr[j] == pivot && j < hi) { j++; }

      return { // returnng a hash/multi-value
        left: i,
        right: j
      }
    }

    swap(arr, i, j);
  }
}

function quicksort(arr, lo, hi) {
  if (lo < hi) {
    p = pivot(arr, lo, hi);
    range = fat_partition(arr, p, lo, hi);  // multiple values
    quicksort(arr, lo, range.left);
    quicksort(arr, range.right, hi);
  }
}

function arr_eq(arr1, arr2) {
  for (var i = 0; i < arr1.length; i++)
    if (arr1[i] != arr2[i])
      return false;
  return i == arr2.length;
}

function randomInt (low, high) {
  return Math.floor(Math.random() * (high - low) + low);
}

function test_sort(size, random_range, presorted='RANDOM') {
  var numbers = new Array(size);

  for (var i = 0; i < numbers.length; i++) {
    numbers[i] = randomInt(1, random_range);
  }

  if (presorted == 'ASK') {
    numbers = numbers.sort(function(a, b){return a-b});
  }
  if (presorted == 'DESC') {
    numbers = numbers.sort(function(a, b){return b-a});
  }

  var node_sorted = numbers.slice(); // duplicate array
  var our_sorted = numbers.slice();  // duplicate array

  var label = 'sort N=' + size.toString()
    + ' Random range: 1..' + random_range.toString()
    + '; Initial state: ' + presorted;

  console.time('NodeJS ' + label);
  node_sorted.sort(function(a, b){return a-b});
  console.timeEnd('NodeJS ' + label);

  console.time('OUR ' + label);
  quicksort(our_sorted, 0, size-1);
  console.timeEnd('OUR ' + label);

  if (arr_eq(our_sorted, node_sorted)) {
    console.log("Sorted!!!\n");
  } else {
    console.log("Our sort failed!!!\n");
    process.exit(1);
  }

//  console.log("Orig arr = %s\n", numbers.toString());
//  console.log("Node sort = %s\n", node_sorted.toString());
//  console.log("Our sorted = %s\n", our_sorted.toString());

}

var fnName = function() {
  var test_lenghts = [ 1000, 10000, 100000, 1000000 ];
//  var test_lenghts = [ 10, 100];
  for (var i=0; i < test_lenghts.length; i++) {
    var test_range = [ 2, 100, 100000 ];
//    var test_range = [ 2 ];
    for (var j=0; j < test_range.length; j++) {
      var test_presort = [ 'ASK', 'DESC', 'RANDOM' ];
      for (var k=0; k < test_presort.length; k++) {
        test_sort(test_lenghts[i], test_range[j], test_presort[k]);
      }
    }
  }
}

if (require.main === module) {
  fnName();
}
