function validateBST(root, parent, left = true) {
  if (!root) {
    return true;
  }
  
  if (!parent) {
    parent = root;  
  }
  
  let isValid = false;
  
  if (left) {
    isValid = root.val <= parent.val;
  }  else {
    isValid = root.val >= parent.val;
  }

  return isValid ?
    validateBST(root.left, root, true) && validateBST(root.right, root, false) :
    false;
}