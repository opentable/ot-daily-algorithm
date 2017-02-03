def all_uniq(s):   
  return len(set(s)) == len(s)

all_uniq("abc")  # True
all_uniq("aabc") # False
