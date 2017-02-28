#include <iostream>
#include <string>
#include <sstream>
using namespace std;

long pow(int x, int n) {
  if (!x || n < 0) return 0;

  long result = 1;
  long multiplier = x;
  while (n > 0) {
    if (1 & n) result *= multiplier;
    multiplier *= multiplier;
    n /= 2;
  }
  return result;
}

int main(int argc, char* argv[]) {
  if(argc < 3) exit(0);

  int x, n;
  if(
    stringstream(argv[1]) >> x
    && stringstream(argv[2]) >> n
  )
    cout << pow(x, n) << '\n';
}
