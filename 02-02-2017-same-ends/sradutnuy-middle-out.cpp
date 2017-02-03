#include<string>

std::string same_ends(const std::string& s) {
  const int upper_bound = s.length();
  const int just_past_middle = upper_bound / 2 + (upper_bound % 2) + 1;

  // uses the middle-out technique
  for (
      int i = s.find_first_of(s[0], just_past_middle);
      i < upper_bound;
      i = s.find_first_of(s[0], ++i)
    ) {
    for (int j = i; j < upper_bound && s[j] == s[j - i]; ++j) {
      if (j == upper_bound - 1) {
        return s.substr(i, upper_bound - 1);
      }
    }
  }

  return std::string();
}
