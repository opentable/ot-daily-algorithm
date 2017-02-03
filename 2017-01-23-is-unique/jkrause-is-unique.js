// Run with node and supply one argument
function hasAllUniqueChars(string) {
    if(!string || string.length <= 1) {
        return true;
    }
    var substring = string.substring(0, string.length-1);
    return hasAllUniqueChars(substring) && !substring.includes(string.charAt(string.length-1));
}

if(process.argv.length < 3) {
    console.log("Error: no argument provided. Please provide a string to verify.");
} else {
    console.log(hasAllUniqueChars(process.argv[2]));
}
