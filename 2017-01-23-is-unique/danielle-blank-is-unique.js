function isUniq(str) {
  var sortedString = str.toLowerCase().split("").sort().join("");

  for (var i = 0; i < sortedString.length; i++) {
    if(sortedString[i] === sortedString[i+1]) {
      return false;
    }
  }
  return true;
}
