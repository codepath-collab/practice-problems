from collections import defaultdict
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        dd = defaultdict(int)
        for i in words:
            dd[i] += 1
        x = sorted(dd.items(), key = lambda t: (-t[1], t[0]))[:k]
        return [i[0] for i in x]
       
