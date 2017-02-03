#include <bitset>
#include <string>

const unsigned long ALPHABET_SIZE = 1 << (3*sizeof(char) - 1);

bool isUnique(const std::string input) {
  std::bitset<ALPHABET_SIZE> bucket;
  for (const char& c : input) {
    if (bucket[c]) {
      return false;
    }
    bucket.set(c, true);
  }
  return true;
}
