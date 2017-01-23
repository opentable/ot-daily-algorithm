#No Extra data structures
def is_unique_no_extras(text):
    sorted_text = sorted(list(text))
    for idx, val in enumerate(sorted_text):
        if idx < (len(sorted_text) -1):
            if val == sorted_text[idx + 1]:
                return False
    return True

#Extra data structures
def is_unique(text):
    return len(text) == len(set(text))