# A Monotonic Stack is a stack-based algorithm that maintains elements in either increasing or 
# decreasing order while processing. It is widely used to solve Next Greater Element, 
# Stock Span, Trapping Rain Water, and similar problems efficiently.

# Explanation

# Normally, finding the "next greater" or "next smaller" 
# element for each item in an array takes O(n²) if we check every element.

# But using a Monotonic Stack, we can do this in O(n) time.

# The stack keeps elements in sorted order (monotonic).

# Monotonic Increasing Stack → smallest at the bottom, largest at the top.

# Monotonic Decreasing Stack → largest at the bottom, smallest at the top.

# While traversing the array, we maintain this property by popping 
# elements that violate the order and pushing the current element.

# 3. Example Problem:

# Find the Next Greater Element (NGE) for each element in the array.
# Input: [2, 1, 5, 6, 2, 3]
# Output: [5, 5, 6, -1, 3, -1]

def next_greater_element(arr):
    n = len(arr)
    res = [-1] * n
    st = []

    for i in range(n):
        while st and arr[i] > arr[st[-1]]:
            idx = st.pop()
            res[idx] = arr[i]
        st.append(i)

    return res

arr = [2, 1, 5, 6, 2, 3]
output = next_greater_element(arr)

print("Input :", arr)
print("Output:", output)
