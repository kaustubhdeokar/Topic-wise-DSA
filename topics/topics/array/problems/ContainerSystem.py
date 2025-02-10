from collections import defaultdict
from sortedcontainers import SortedSet

class ContainerSystem:
    index_to_num = {}
    num_to_indexes = defaultdict(SortedSet)

    def change(self, index, number):
        if index in self.index_to_num:
            earlier_num = self.index_to_num[index]
            self.num_to_indexes[earlier_num].remove(index)
        if number not in self.num_to_indexes:
            self.num_to_indexes[number] = SortedSet()
        self.num_to_indexes[number].add(index)
        self.index_to_num[index] = number
        print(self.num_to_indexes)
        # print(self.index_to_num)

    def find(self, number):
        if number not in self.num_to_indexes or len(self.num_to_indexes[number]) == 0:
            return -1
        else:
            sorted_set = self.num_to_indexes[number]
            return (sorted_set[0])
            #return self.num_to_indexes[number]

input = [[10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
cs = ContainerSystem()
for i in input:
    if len(i)==2:
        cs.change(i[0], i[1])
    else:
        print(cs.find(i[0]))
