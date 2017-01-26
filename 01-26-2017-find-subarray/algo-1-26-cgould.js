#!/usr/bin/env node


function findZeroSumByBruteForce(arr) {
	var foundOne = false;
	for (var i = 0; i < arr.length; i++ ) {
		for ( j = i; j < arr.length; j++ )  {
			var k = i;
			var sum = 0;
			while (k <= j) {
				sum += arr[k];
				k++;
			}
			if (sum == 0) {
				console.log("true");
				console.log("There is a subarray with zero sum from index " + i + " to " + j );
				foundOne = true;
			}
		}
	}
	if (!foundOne)
		console.log("There is no subarray with zero sum.")
}

findZeroSumByBruteForce([4, 2, -3, 1, 6]);
findZeroSumByBruteForce([4, 2, 0, 1, 6]);
findZeroSumByBruteForce([-3, 2, 3, 1, 6]);