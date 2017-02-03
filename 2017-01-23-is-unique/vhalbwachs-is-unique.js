// sort first
function isUnique(str) {
  return str.split('')
    .sort()
    .every((letter, i, sorted) => i === 0 || letter !== sorted[i - 1]);
}

// using a set
function isUnique(str) {
  const seen = new Set();
  for (const letter of str) {
    if (seen.has(letter)) {
      return false;
    }
    seen.add(letter);
  }

  return true;
}
