function min(node, currMin) {
  if (!node) {
    return currMin;
  }

  if (!currMin || node.val <= currMin) {
    currMin = node.val;
  }

  let leftMin = min(node.left, currMin);
  let rightMin = min(node.right, currMin);

  if (leftMin < rightMin) {
    currMin = leftMin;
  } else {
    currMin = rightMin;
  }

  return currMin;
}

function max(node, currMax) {
  if (!node) {
    return currMax;
  }
  
  if (!currMax || node.val >= currMax){
    currMax = node.val;
  }
  
  const leftMax = max(node.left, currMax);
  const rightMax = max(node.right, currMax);
  
  if (leftMax > rightMax) {
    currMax = leftMax;
  } else {
    currMax = rightMax;
  }

  return currMax;
}

function validateBST(node) {
  if (!node) {
    return true;
  }

  if (node.left &&  max(node.left) > node.val) {
    return false;
  }

  if (node.right && min(node.right) < node.val) {
    return false;
  }

  return validateBST(node.left) && validateBST(node.right);
}
