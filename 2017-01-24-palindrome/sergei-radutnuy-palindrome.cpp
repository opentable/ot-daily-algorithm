#include<forward_list>
#include<stack>

template<typename T>
bool isPalindrome(std::forward_list<T>& input) {
  auto normalPtr = input.begin();
  auto doubleSpeedPtr = input.begin();
  auto const end = input.end();

  std::stack<T> firstHalfElems = std::stack<T>();
  while (doubleSpeedPtr != end) {
    firstHalfElems.push_back(*(normalPtr++));

    // the list length is odd, don't need to check middle element
    if (++doubleSpeedPtr == end) {
      firstHalfElems.pop_back();
      ++normalPtr;
      break;
    }
    ++doubleSpeedPtr;
  }

  while(!firstHalfElems.empty()) {
    if(*(normalPtr++) != *(firstHalfElems.pop())) {
      return false;
    }
  }

  return true;
}
