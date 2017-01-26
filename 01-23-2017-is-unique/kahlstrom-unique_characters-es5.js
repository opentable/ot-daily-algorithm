// UTF-16 aware ES5 solution

function is_consisting_of_only_unique_characters(string) {
  // Unicode 9 has 267,819 assigned codepoints. This is the max amount of keys we could end up storing
  var has_seen_character = {};

  for(var i = 0; i < string.length; i++) {
    var code = string.charCodeAt(i);
    var character = string.charAt(i);

    // Without this we would incorrectly report >BMP characters living close to each other as not unique, as the high surrogate character would be the same
    if(code >= 55296 && code <= 56319) {
      // High surrogate, we need to look at the next char code to get the full picture
      if(i < string.length - 1) {
        character = character + string.charAt(i+1);
        i++;
      }
      else {
        // Malformed UTF-16 ¯\_(ツ)_/¯
      }
    }

    if(has_seen_character[character]) {
      return false;
    }

    has_seen_character[character] = true;
  }

  return true;
}

var string1 = "ÅÄÖ \u0041\u0308"; // Will be incorrectly marked as unique since the last Ä is decomposed
var string2 = "👨‍❤️‍💋‍👨 \uD83D\uDC69\u200D\u2764\uFE0F\u200D\uD83D\uDC8B\u200D\uD83D\uDC69"; // Will be incorrectly marked as unique as we're not iterating over grapheme clusters
var string3 = "🇸🇪🏳️‍🌈";
var string4 = "ﬀ f";
var string5 = "𠁧𠁳";

console.log(is_consisting_of_only_unique_characters(string1) ? string1 + "\t is unique" : string1 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string2) ? string2 + "\t is unique" : string2 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string3) ? string3 + "\t is unique" : string3 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string4) ? string4 + "\t is unique" : string4 + "\t is not unique");
console.log(is_consisting_of_only_unique_characters(string5) ? string5 + "\t is unique" : string5 + "\t is not unique");
