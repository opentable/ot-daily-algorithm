function isUnique(str) {
  let occurrence = '';
  
  for (let i=0; i<str.length; i++)
    if (occurrence.indexOf(str[i]) == -1) {
      occurrence = occurrence + str[i];
    } else {
      return false;
    }

  return true;
}


console.log(isUnique('aabcc')); // false
console.log(isUnique('abc'));  // true
console.log(isUnique('a')); // true
console.log(isUnique(''));  // true
