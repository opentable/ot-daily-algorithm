var sumZero = function(n) {
    var sum = [];
    var isEven = n % 2 === 0;
    var startingIndex = isEven ? 1 : 0;
    var endingIndex = isEven ? n/2 : (n-1) /2;
    for (var i = startingIndex; i <= endingIndex; i ++) {
        sum.push(i);
        if (i !== 0) {
           sum.unshift(i * -1); 
        }
    }
    
    return sum;
};