// traverse list adding to stack
// pop each item off the stack while re-traversing the list 
// should be equal for each iteration 
function isPalindrome(head) {
  if (!head) { return false; }

  let stack = [];
  let temp = head;
  while(temp !== null) {
    stack.push(temp.val);
    temp = temp.next;
  }
  
  // reset temp to point to start of list
  temp = head;
  
  // pop values off stack and compare with each value in list
  for (var i = stack.length -1; i >= 0; i--) {
    if (temp.val !== stack[i]){
      return false;
    }
    temp = temp.next;
  }

  return true;
}

const list = {
  val: 'r',
  next: {
    val: 'a',
    next: {
      val: 'c',
      next: {
        val: 'e',
        next: {
          val: 'c',
          next: {
            val: 'a',
            next: {
              val: 'r',
              next: null
            }
          }
        }
      }
    }
  }
}
const list1 = {
  val: 'r',
  next: {
    val: 'b',
    next: null
  }
};

const list2 = {
  val: 'r',
  next: null
};

const list3 = {
  val: 'r',
  next: {
    val: 'b',
    next: {
      val: 'r',
      next: null
    }
  }
};
isPalindrome(list) // true
isPalindrome(list1) // false
isPalindrome(list2) // true
isPalindrome(list3) // true