function isPalindrome(linkedList) {
  var halfLength = Math.ceiling(linkedList.count/2);

  var reversedList = linkedList;
  var temp = reversedList.first
  while (temp !== null) {
    temp = temp.next
    if (i => halfLength) {
      next = temp.next
      temp.next = temp
      temp = temp.next
    }
  }

  var first = reversedList.first
  var last = reversedList.last
  for(var i = 0; i < halfLength; i++) {
    if (first.data !== last.data) {
      return false;
    }
    first = first.next;
    last = last.next;
  }

  return true;
}
