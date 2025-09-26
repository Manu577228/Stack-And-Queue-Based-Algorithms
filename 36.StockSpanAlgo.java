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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio       */
/* -----------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

public class StockSpan {

    // Function to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;          // total number of days
        int[] span = new int[n];        // result array for span of each day
        Stack<Integer> st = new Stack<>();  // stack to store indices of days

        // Span of first day is always 1
        span[0] = 1;
        st.push(0);  // push index of first day

        // Traverse the array from day 1 to day n-1
        for (int i = 1; i < n; i++) {
            
            // Pop elements while current price is higher or equal
            while (!st.isEmpty() && prices[i] >= prices[st.peek()]) {
                st.pop();
            }

            // If stack is empty → all previous prices are smaller
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Otherwise, span is distance between current index and last higher price index
                span[i] = i - st.peek();
            }

            // Push this index into the stack
            st.push(i);
        }

        return span;
    }

    public static void main(String[] args) throws IOException {
        // Example prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Call the function
        int[] result = calculateSpan(prices);

        // Print prices
        System.out.println("Prices: " + Arrays.toString(prices));
        // Print spans
        System.out.println("Span:   " + Arrays.toString(result));
    }
}
