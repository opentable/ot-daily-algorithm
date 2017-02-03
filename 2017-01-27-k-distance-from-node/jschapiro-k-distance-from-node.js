function nodesAtK(root, k, count, elements) {
  if (!root || !root.val) {
    return;
  }
  
  if (!count || !elements) {
    count = 0;
    elements = [];
  }
  
  const newCount = count + 1;
  
  if (newCount === k) {
    elements.push(root.val);
  }
  
  nodesAtK(root.left, k, newCount, elements);
  nodesAtK(root.right, k, newCount, elements);
  
  return elements;
}