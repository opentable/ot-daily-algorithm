function isUniqueWithDS(text) {
    let occurences = {};

    for(let character of text) {
        occurences[character] = (occurences[character] || 0) + 1;
        if(occurences[character] > 1)
            return false;
    }

    return true;
}

function isUniqueWithoutDS(text) {
    for(let character of text) {
        if(text.split(character).length > 2)
            return false;
    }

    return true;
}

console.log(`isUniqueWithDS('abcdefgh') -> '${isUniqueWithDS('abcdefgh')}'`);     // isUniqueWithDS('abcdefgh') -> true
console.log(`isUniqueWithDS('abcdefgha') -> '${isUniqueWithDS('abcdefgha')}'`);     // isUniqueWithDS('abcdefgha') -> false
console.log(`isUniqueWithDS('') -> '${isUniqueWithDS('')}'`);     // isUniqueWithDS('') -> true

console.log(`isUniqueWithoutDS('abcdefgh') -> '${isUniqueWithoutDS('abcdefgh')}'`);     // isUniqueWithoutDS('abcdefgh') -> true
console.log(`isUniqueWithoutDS('abcdefgha') -> '${isUniqueWithoutDS('abcdefgha')}'`);     // isUniqueWithoutDS('abcdefgha') -> false
console.log(`isUniqueWithoutDS('') -> '${isUniqueWithoutDS('')}'`);     // isUniqueWithoutDS('') -> true