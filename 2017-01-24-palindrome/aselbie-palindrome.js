if (Array.prototype.toList === undefined) {
  Array.prototype.toList = function() {
    const head = new Node(this[0]);
    let tail = head;

    for (i = 1; i < this.length; i++) {
      tail = tail.insert(this[i]);
    }

    return head;
  }
}

class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next
  }

  insert(data) { 
    const node = new Node(data, this.next);
    this.next = node;
    return node;
  }

  reverse(prev = null) {
    const next = this.next;
    this.next = prev;
    if (next === null) return this;
    return next.reverse(this);
  }

  isPalindrome(reverse = this.reverse()) {
    if (this.data !== reverse.data) return false;
    if (this.next === null) return true;
    return this.next.isPalindrome(reverse.next);
  }
}

console.log(['a', 'b', 'c'].toList().isPalindrome()); // false
console.log(['a', 'b', 'c', 'b', 'a'].toList().isPalindrome()); // true
