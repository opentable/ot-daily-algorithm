// TODO: cleanup code/ edge case checking
function printList(head) {
  let curr = head;

  while(curr) {
    console.log(curr.val);
    curr = curr.next;
  }
}

function insertValue(head, val, cb) {
  let curr = head;

  while (curr.next) {
    curr = curr.next;
  }

  curr.next = {val, next: null}
  if (cb) {
    cb(curr.next);
  }
  
  return head;
}

function partition(head, val) {
  let firstHalf;
  let secondHalf = {val, next: null};
  let firstTail;
  let partitionExists = false;
  
  let curr = head;
  
  while(curr) {
    if (curr.val < val) {
      if (!firstHalf) {
        firstHalf = { val: curr.val, next:null };
        firstTail = firstHalf;
      } else {
        firstHalf = insertValue(firstHalf, curr.val, tail => {
          firstTail = tail;
        });
      }
    } else if (curr.val > val) {
      if (!secondHalf) {
        secondHalf = { val: curr.val, next:null };
      } else {
        secondHalf = insertValue(secondHalf, curr.val);
      }
    }  else {
      partitionExists = true;
    }
    curr = curr.next;
  }

  firstTail.next = secondHalf;

  return partitionExists ? firstHalf : head;
}