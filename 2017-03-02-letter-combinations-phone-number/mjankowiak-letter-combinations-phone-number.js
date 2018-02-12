const digitToLetterMapping = {
  "1": "",
  "2": "abc",
  "3": "def",
  "4": "ghi",
  "5": "jkl",
  "6": "mno",
  "7": "pqrs",
  "8": "tuv",
  "9": "wxyz"
}


function generateLetterCombination(sequence, digitString) {
  if(!digitString){
    console.log(sequence);
    return;
  }

  if(!digitToLetterMapping[digitString[0]]) {
    return generateLetterCombination(sequence, digitString.substring(1));
  }

  for(let character of digitToLetterMapping[digitString[0]]) {
    generateLetterCombination(`${sequence}${character}`, digitString.substring(1));
  }
}

function generateLetterCombinations(digitString) {
  if(!digitString)
    console.log("");
  
  generateLetterCombination("", digitString);
}

console.log("generateLetterCombinations('23') ->");
generateLetterCombinations("23");
console.log("generateLetterCombinations('a2b3') ->");
generateLetterCombinations("a2b3");
console.log("generateLetterCombinations('0oa2b3') ->");
generateLetterCombinations("0oa2b3");