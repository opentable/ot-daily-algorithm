/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var numMap = {};
    // generate hash map for easy num look up
    for (var i = 0; i < nums.length -1; i ++) {
        numMap[nums[i]] = i;
    }
    
    // reference hash map to find a corresponding number that sums up to target
    for (var j = 0; j <nums.length; j ++) {
       var diff = Math.abs(nums[j] - target);
        var indexOfPairMatch = numMap[diff]
       if (indexOfPairMatch) {
           pair = [numMap[diff], j];
           break;
       } 
    }
    return pair;
};