from collections import defaultdict

_helper = lambda t, s: reduce(lambda a, x: a[x] if x in a else None, s, t)

trie = lambda: defaultdict(trie)
insert = lambda t, s: reduce(lambda a, x: a[x], s, t)
search = lambda t, s: len(_helper(t, s)) == 0
startsWith = lambda t, s: _helper(t, s) is not None

t = trie()
insert(t, 'abcdefg')
print search(t, 'abcd')
print startsWith(t, 'abcd')
print search(t, 'abcdefg')
