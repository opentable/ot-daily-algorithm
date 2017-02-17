const match = (left, right) =>
  (left === '(' && right === ')') ||
  (left === '[' && right === ']') ||
  (left === '{' && right === '}')

const validParentheses = (str) => str
  .split('')
  .reduce((stack, char) => {
    const top = stack[stack.length - 1]

    if (match(top, char)) {
      stack.pop()
    } else {
      stack.push(char)
    }

    return stack
  }, [])
  .length === 0

console.log(validParentheses("()")) // true
console.log(validParentheses("()[]{}")) // true
console.log(validParentheses("(]")) // false
console.log(validParentheses("([)]")) // false