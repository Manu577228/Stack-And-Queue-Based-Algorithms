# Expression evaluation is the process of finding the result of a mathematical expression
# written in infix, postfix, or prefix form.
# Stack and queue-based algorithms help evaluate
# these expressions efficiently by following operator precedence and associativity rules.

# Explanation

# Infix expressions are the usual ones we write: 3 + 5 * 2.

# Postfix (Reverse Polish Notation): 3 5 2 * +.

# Using stacks:

# One stack for operands (numbers).

# Another stack for operators (+, -, *, /).

# Algorithm steps (for infix evaluation):

# Scan the expression left to right.

# If it’s a number → push to operand stack.

# If it’s an operator → pop operators from operator stack with higher
# or equal precedence, evaluate, then push the result back.

# If it’s ( → push to operator stack.

# If it’s ) → keep popping and evaluating until ( is found.

# After scanning, evaluate remaining operators.

def precedence(op):
    if op == '+' or op == '-':
        return 1
    if op == '*' or op == '/':
        return 2
    return 0


def apply_op(a, b, op):
    if op == '+':
        return a + b
    if op == '-':
        return a - b
    if op == '*':
        return a * b
    if op == '/':
        return a // b


def evaluate(expression):
    nums = []
    ops = []
    i = 0
    while i < len(expression):
        if expression[i] == ' ':
            i += 1
            continue

        elif expression[i].isdigit():
            val = 0
            while i < len(expression) and expression[i].isdigit():
                val = (val * 10) + int(expression[i])
                i += 1
            nums.append(val)
            continue

        elif expression[i] == '(':
            ops.append(expression[i])

        elif expression[i] == ')':
            while ops and ops[-1] != '(':
                b = nums.pop()
                a = nums.pop()
                op = ops.pop()
                nums.append(apply_op(a, b, op))
            ops.pop()

        else:
            while ops and precedence(ops[-1]) >= precedence(expression[i]):
                b = nums.pop()
                a = nums.pop()
                op = ops.pop()
                nums.append(apply_op(a, b, op))
            ops.append(expression[i])
        i += 1

    while ops:
        b = nums.pop()
        a = nums.pop()
        op = ops.pop()
        nums.append(apply_op(a, b, op))

    return nums[-1]


expr = "3 + 5 * ( 2 - 8 )"
print("Expression:", expr)
print("Result:", evaluate(expr))
