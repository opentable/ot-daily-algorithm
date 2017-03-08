#include <cassert>
#include <forward_list>
#include <iostream>
#include <stack>
#include <string>

template<typename T>
bool isPalindrome(const std::forward_list<T>& input) {
  auto normalPtr = input.begin();
  auto doubleSpeedPtr = input.begin();
  auto const end = input.end();

  std::stack<T> firstHalfElems = std::stack<T>();
  while (doubleSpeedPtr != end) {
    firstHalfElems.push(*normalPtr);
    ++doubleSpeedPtr;
    // this happens if list is of odd length
    if (doubleSpeedPtr == end) break;
    ++normalPtr;
    ++doubleSpeedPtr;
  }

  while (!firstHalfElems.empty()) {
    if (*normalPtr != firstHalfElems.top()) return false;
    ++normalPtr;
    firstHalfElems.pop();
  }

  return true;
}

int main(int argc, char** argv) {
  std::forward_list<int> even_palindrome = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
  assert(isPalindrome(even_palindrome));

  std::forward_list<int> odd_palindrome = {1, 2, 3, 4, 5, 4, 3, 2, 1};
  assert(isPalindrome(odd_palindrome));

  std::forward_list<int> not_palindrome = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  assert(!isPalindrome(not_palindrome));
}
