function insert(head, word) {
  if (!head) {
    head = {word:false};
  }
  if (!word) {
    return head;
  }

  let currTrie = head;
  
  _.forEach(word, w => {
    if (!currTrie[w]) {
      currTrie[w] = {word: ''};
      currTrie = currTrie[w];
    } else {
      currTrie = currTrie[w];
    }
  });
  
  currTrie.word = '$';
  return head;
}

function search(head, word) {
  if (!word) {
    return false;
  }
  let currTrie = head;
  
  for (var i = 0; i < word.length; i ++) {
    if (currTrie[word[i]]) {
      currTrie = currTrie[word[i]];
    } else {
      return false;
    }
  }
  
  return true;
}