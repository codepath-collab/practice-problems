class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        pushed_index = 0
        popped_index = 0
        newStack = []
        d = {}
        while popped_index < len(popped):
            while len(newStack) > 0 and popped[popped_index] == newStack[len(newStack)-1]:
                del d[newStack.pop()]
                popped_index += 1
            if popped_index < len(popped) and popped[popped_index] in d:
                return False
            if pushed_index < len(pushed):
                newStack.append(pushed[pushed_index])
                d[pushed[pushed_index]] = True
                pushed_index += 1
        return True
