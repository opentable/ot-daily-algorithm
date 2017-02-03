// string -> bool
// checks to see if first char in string exists in rest of string
function firstCharExists(string) {
  return string.substring(1, string.length).indexOf(string[0]) === -1;
}

// str -> bool
function isUnique(str) {
  if (!str || !str.length){return true};
  return isUnique(str.slice(1)) && firstCharExists(str);
}

isUnique('aba') // false
isUnique('abc') // false