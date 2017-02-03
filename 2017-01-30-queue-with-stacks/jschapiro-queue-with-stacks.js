function queueFromStack() {
  const stack1 = [];
  const stack2 = [];
  
  function _pop() {
    if (stack1.length) {
      return stack1.pop();
    }

    throw new Error('Queue is empty');
  }
  
  function _push(val) {
    // move all items from stack1 to stack2 until stack1 empty
    while(stack1.length) {
      stack2.push(stack1.pop());
    }
    
    // insert new item into stack1
    stack1.push(val);
    
     // move all items from stack2 back to stack1
    while(stack2.length) {
      stack1.push(stack2.pop());
    }
    
    return stack1;
  }
  
  return {
    push: _push,
    pop: _pop
  };
}

const ds = queueFromStack();
ds.push('a');
ds.push('b');
ds.push('c');
ds.push('d');
ds.pop(); // a
ds.pop(); // b
ds.pop(); // c
ds.pop(); // d
ds.pop(); // throws