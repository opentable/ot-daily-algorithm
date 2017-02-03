function bunnyEars(n) {
  if (n === 0) {
    return 0;
  }
  return n % 2 === 0 ?
   bunnyEars(n -1) + 3 :
   bunnyEars(n-1) + 2;
}

bunnyEars2(0) // 0

bunnyEars2(1) // 2

bunnyEars2(2) // 5