function sameEnds(string) {
  if (!string) { return '' }
  let midpoint = Math.floor(string.length/2);
  
  //offset for even length strings
  let j = string.length % 2 > 0 ? 1 : 0;

  for (let i = j; i < midpoint; i++) {
    const firstHalf = string.slice(0, midpoint - i + j);
    const secondHalf = string.slice(midpoint + i, string.length);
    if (firstHalf === secondHalf) {
      return firstHalf;
    }
  }

  return '';
}
