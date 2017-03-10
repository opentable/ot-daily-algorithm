#include <cassert>
#include <iostream>
#include <vector>

using namespace std;

// TODO: can do better than O(n^2)?
bool zeroSubarray(const vector<int>& a) {
  int accum = 0;
  vector<int> cdf;
  for (int x : a) {
    if (!x) return true;
    accum += x;
    cdf.push_back(accum);
  }

  for (int i = 0; i < a.size(); ++i) {
    for (int j = i + 1; j < a.size(); ++j) {
      if (cdf[j] - cdf[i] == 0) return true;
    }
  }

  return false;
}

int main() {
  vector<int> a;
  assert(!zeroSubarray(a));

  vector<int> b = {0};
  assert(zeroSubarray(b));

  vector<int> c = {4, 2, -3, 1, 6};
  assert(zeroSubarray(c));

  vector<int> d = {4, 2, 0, 1, 6};
  assert(zeroSubarray(d));

  vector<int> e = {-3, 2, 3, 1, 6};
  assert(!zeroSubarray(e));
}
