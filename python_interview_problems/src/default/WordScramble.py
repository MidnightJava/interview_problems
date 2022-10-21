'''
Created on Feb 1, 2018

@author: maleone
'''
from itertools import permutations
from collections import defaultdict

class WordScramble:

	def __init__(self, s1, s2):
		self.s1 = s1
		self.s2 = s2

	def solve(self):
		d2 = defaultdict(int);
		for c in self.s2:
			d2[c]+=1
		for p in permutations(self.s1, len(self.s2)):
			d1 = defaultdict(int);
			for c in p:
				d1[c]+=1
			if d1 == d2:
				return True
		return False

print WordScramble('coder','coderx').solve() # False
print WordScramble('coderx','coder').solve() # True
print WordScramble('h3llo','hello').solve() # False
print WordScramble('abcdef','daebfc').solve() # True
