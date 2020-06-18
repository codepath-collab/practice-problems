#Done without a heap
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        answer = []
        for i in nums1:
            for j in nums2:
                answer.append([i,j])
        answer = sorted(answer, key = lambda t: sum(t))
        return answer[:k]
