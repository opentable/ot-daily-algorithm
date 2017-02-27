function pow(x, n) {
  if (n === 0) {
    return 1;
  }
  
  if (n === 1) {
    return x;
  }
  
  return x * pow(x, n-1);
}
