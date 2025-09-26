# A Monotonic Queue is a special type of queue that maintains its 
# elements in either increasing or decreasing order.
# It allows us to efficiently find minimum or maximum values in a sliding window over an array.

# Explanation

# Imagine you want to find the maximum in every sliding window of size k in an array.

# If we just check all k elements for every window, it would be slow (O(n*k)).

# A Monotonic Queue stores elements in a way that the front always has the answer (max or min), 
# and useless elements are removed as new ones come in.

# Operations:

# Push(x) – Insert x but remove smaller elements (for max queue).

# Pop(x) – Remove x if it’s at the front of the queue.

# Max/Min() – Return the element at the front.

# This makes sliding window problems efficient in O(n).

from collections import deque

class MonotonicQueue:
    def __init__(self):
        self.q = deque()

    def push(self, x):
        while self.q and self.q[-1] < x:
            self.q.pop()
        self.q.append(x)

    def max(self):
        return self.q[0]
    
    def pop(self, x):
        if self.q and self.q[0] == x:
            self.q.popleft()

def sliding_window_max(nums, k):
    mq = MonotonicQueue()
    res = []

    for i in range(k):
        mq.push(nums[i])
    res.append(mq.max())

    for i in range(k, len(nums)):
        mq.push(nums[i])
        mq.pop(nums[i - k])
        res.append(mq.max())

    return res;

arr = [1, 3, -1, -3, 5, 3, 6, 7]
window_size = 3
output = sliding_window_max(arr, window_size)
print(output)

