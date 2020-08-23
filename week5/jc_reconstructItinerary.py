from collections import defaultdict
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        num = 0
        dd = defaultdict(list)
        for depart, arrive in tickets:
            dd[depart].append(arrive)
            num += 1
        for i in dd.keys():
            dd[i].sort()
        
        def dfs(pairs: dict, order: [str]):
            if len(pairs) == 0:
                #first solution found will be the answer because we previously sorted each list
                return order
            elif order[-1] not in pairs:
                #(wrong path taken)
                return
            else:
                latest = order[-1]
                temp = pairs[latest].copy()
                for arrival in temp:
                    order.append(arrival)
                    pairs[latest].remove(arrival)
                    if len(pairs[latest]) == 0:
                        del pairs[latest]
                    potential = dfs(pairs, order)
                    if potential != None and len(potential) == num+1:
                        return potential
                    pairs[latest].append(arrival)
                    order.pop()
            
        return dfs(dd, ["JFK"])
