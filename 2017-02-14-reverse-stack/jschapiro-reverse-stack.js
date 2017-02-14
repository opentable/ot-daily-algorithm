function reverseStack(stack) {
  if (!stack || !stack.length) {
    return;
  }
  
  // maintain ref to curr value in stack frame
  let curr = stack.pop();
  
  // continue to traverse stack
  reverseStack(stack);
  
  // after final traversal, begin to add values to empty stack
  stack.push(curr);
  return stack;
}