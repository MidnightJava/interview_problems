'''
Created on Jan 5, 2017

@author: maleone

Print each word from the input, along with the number of times it appears.
Print the word/frequency values in alphabetical order and then again in order of their frequency.
Do each sort in ascending as well as descending order.
'''

from collections import defaultdict

def solve(inp, ascending, sortByFreq):
    words = defaultdict(int)
    for w in inp.split():
        words[w.lower()]+= 1
    for v in sorted(words.items(), key = lambda x: x[0] if not sortByFreq else x[1], reverse = not ascending):
        print "\t%s\tfrequency:%d" % (v[0], v[1])
    print

inp = "The quick brown fox jumped over a lazy dog two two three three three four four four four"
print "Sort by frequency in ascending order:"
solve(inp, True, True)
print "Sort alphabetically in ascending order:"
solve(inp, True, False)
print "Sort by frequency in desccending order:"
solve(inp, False, True)
print "Sort alphabetically in descending order:"
solve(inp, False, False)