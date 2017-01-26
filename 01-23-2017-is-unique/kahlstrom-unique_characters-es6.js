// UTF-16 aware ES6 solution

function is_consisting_of_only_unique_characters(string) {
  // Unicode 9 has 267,819 assigned codepoints. This is the max amount of keys we could end up storing
  let has_seen_character = {};

  for(let codepoint of string) {
    if(has_seen_character[codepoint]) {
      return false;
    }

    has_seen_character[codepoint] = true;
  }

  return true;
}

const string1 = "ÅÄÖ \u{41}\u{308}"; // Will be incorrectly marked as unique since the last Ä is decomposed
const string2 = "👨‍❤️‍💋‍👨\u{1F469}\u{200D}\u{2764}\u{FE0F}\u{200D}\u{1F48B}\u{200D}\u{1F469}"; // Will be incorrectly marked as unique as we're not iterating over grapheme clusters
const string3 = "🇸🇪🏳️‍🌈";
const string4 = "ﬀ f";
const string5 = "𠁧𠁳";

console.log(is_consisting_of_only_unique_characters(string1) ? string1 + "\t is unique" : string1 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string2) ? string2 + "\t is unique" : string2 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string3) ? string3 + "\t is unique" : string3 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string4) ? string4 + "\t is unique" : string4 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string5) ? string5 + "\t is unique" : string5 + "\t is not unique");
