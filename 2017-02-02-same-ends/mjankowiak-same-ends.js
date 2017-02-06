function sameEnds(string) {
  var sameEnd = '';
  var i = 0;
  
  for(var j = Math.ceil(string.length / 2); j < string.length; j++) {
    if(string[i] === string[j]) {
      sameEnd += string[j];
      i++;
    } else {
      i = 0;
      sameEnd = '';
    }
  }

  return sameEnd;
}

console.log(`sameEnds('abXYab') -> '${sameEnds('abXYab')}'`);     // sameEnds('abXYab') -> 'ab'
console.log(`sameEnds('xxx') -> '${sameEnds('xxx')}'`);           // sameEnds('xxx') -> 'x'
console.log(`sameEnds('xx') -> '${sameEnds('xx')}'`);             // sameEnds('xx') -> 'x'
console.log(`sameEnds('abXYabz') -> '${sameEnds('abXYabz')}'`);   // sameEnds('abXYabz') -> ''
console.log(`sameEnds('abxyabbb') -> '${sameEnds('abxyabbb')}'`); // sameEnds('abxyabbb') -> ''
console.log(`sameEnds('') -> '${sameEnds('')}'`);                 // sameEnds('') -> ''
console.log(`sameEnds('abzXYabz') -> '${sameEnds('abzXYabz')}'`); // sameEnds('abzXYabz') -> 'abz'