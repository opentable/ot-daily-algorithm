'use strict'

// Implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use additional data structures?

function isUnique(input) {

  let unique = true

  input.toLowerCase()
       .replace(/\s/g,'')
       .split('')
       .sort()
       .map((el, idx, arr) => {
        if (idx < (arr.length - 1)) {
          if (arr[idx] === arr[idx+1]) {
            unique = false
          }
        }
       })

  return unique

}

console.log(isUnique('I am true') === true);
console.log(isUnique('I am false') === false);