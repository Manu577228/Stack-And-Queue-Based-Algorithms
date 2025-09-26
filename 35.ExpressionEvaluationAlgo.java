/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )
 ___ _                      _              _ 
 | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)
 | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |
 |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |
                                        |__/ 
 */
/* --------------------------------------------------------------------------   */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                        */
/*    Github : https://github.com/Manu577228                                  */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio      */
/* -----------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

public class ExpressionEvaluation {

    // Function to define precedence of operators
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Function to apply operator to two operands
    static int applyOp(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return a / b; // integer division
        return 0;
    }

    // Function to evaluate the infix expression
    static int evaluate(String expression) {
        Stack<Integer> nums = new Stack<>(); // stack for numbers
        Stack<Character> ops = new Stack<>(); // stack for operators

        int i = 0;
        while (i < expression.length()) {

            // Skip spaces
            if (expression.charAt(i) == ' ') {
                i++;
                continue;
            }

            // If current char is a digit → read full number
            if (Character.isDigit(expression.charAt(i))) {
                int val = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    val = (val * 10) + (expression.charAt(i) - '0');
                    i++;
                }
                nums.push(val);
                continue;
            }

            // If '(' push it to ops
            else if (expression.charAt(i) == '(') {
                ops.push(expression.charAt(i));
            }

            // If ')' → solve until '('
            else if (expression.charAt(i) == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    int b = nums.pop();
                    int a = nums.pop();
                    char op = ops.pop();
                    nums.push(applyOp(a, b, op));
                }
                ops.pop(); // remove '('
            }

            // If operator encountered
            else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(expression.charAt(i))) {
                    int b = nums.pop();
                    int a = nums.pop();
                    char op = ops.pop();
                    nums.push(applyOp(a, b, op));
                }
                ops.push(expression.charAt(i));
            }
            i++;
        }

        // Apply remaining operators
        while (!ops.isEmpty()) {
            int b = nums.pop();
            int a = nums.pop();
            char op = ops.pop();
            nums.push(applyOp(a, b, op));
        }

        return nums.peek();
    }

    public static void main(String[] args) {
        String expr = "3 + 5 * ( 2 - 8 )";
        System.out.println("Expression: " + expr);
        System.out.println("Result: " + evaluate(expr));
    }
}
