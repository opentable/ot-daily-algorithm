int bunny_ears(int a, int b) {
  return b < 1 ? a : bunny_ears(2 + (b % 2), b - 1);
}

int bunny_ears(int n) {
  return bunny_ears(0 , n);
}
