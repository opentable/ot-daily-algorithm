bunnyEars := method(n,
  if(n == 0, return 0)
  return bunnyEars(n - 1) + 2 + (n + 1)%2
)

for(i, 0, 10, writeln("bunnyEars(", i, ") → ", bunnyEars(i)))