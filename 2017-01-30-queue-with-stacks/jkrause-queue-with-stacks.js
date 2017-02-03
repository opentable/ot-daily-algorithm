#! /usr/bin/env node
// Queue using a stack to hold data
var queue = {
    // using array as stack since it has built in push and pop operations
    queueStack: [],
    enqueue: function(value) {
        var next = this.queueStack.pop();
        if(next === undefined) {
            this.queueStack.push(value);
        } else { 
            this.enqueue(value);
            this.queueStack.push(next);
        }
    },
    dequeue: function() {
        return this.queueStack.pop();
    }
}

var data = [0,1,2,3,4,5,6,7,8,9];
data.forEach(function(i) {
    queue.enqueue(i);
});
for(var i = 0; i < data.length; i++) {
    console.log(queue.dequeue());
}
