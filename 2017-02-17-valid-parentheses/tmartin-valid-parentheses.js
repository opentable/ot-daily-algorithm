'use strict';

function validParentheses(parentheses) {

  const parensArray = parentheses.split('')
  const stack = []
  let isValid = false

  parensArray.map(p => {
    if ('({['.indexOf(p) > -1) {
      stack.push(p)
    }
    else {
      let match = stack.pop()
      if (
          !match ||
          match == '(' && p != ')' ||
          match == '{' && p != '}' ||
          match == '[' && p != ']'
         ) {
        isValid = false
      } else {
        isValid = true
      }
    }
  })

  return isValid

}

console.log(validParentheses('(')) // => false
console.log(validParentheses(')')) // => false
console.log(validParentheses('()')) // => true
console.log(validParentheses('()[]{}')) // => true
console.log(validParentheses('(]')) // => false
console.log(validParentheses('([)]')) // => false