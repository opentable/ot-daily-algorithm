#include <bitset>
#include <iostream>
#include <string>
#include <sstream>

constexpr uint64 ALPHABET_SIZE = 1 << 8 * sizeof(char);

bool isUnique(const std::string input) {
  std::bitset<ALPHABET_SIZE> bucket;
  for (char c : input) {
    if (bucket[c]) return false;
    bucket.set(c, true);
  }
  return true;
}

int main(int argc, char** argv) {
  if (argc < 2) exit(0);
  std::cout << (isUnique(argv[1]) ? "true" : "false") << '\n';
}
