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

public class MonotonicStackNGE {

    // Function to find Next Greater Element
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;                // 1. Size of the array
        int[] res = new int[n];            // 2. Result array
        Arrays.fill(res, -1);              // 3. Initialize all values to -1
        Deque<Integer> st = new ArrayDeque<>(); // 4. Stack to hold indexes

        for (int i = 0; i < n; i++) {      // 5. Traverse array
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                // 6. If current element > element at top index of stack
                int idx = st.pop();        // 7. Pop index
                res[idx] = arr[i];         // 8. Set result for that index
            }
            st.push(i);                    // 9. Push current index
        }
        return res;                        // 10. Return result array
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // Example input
        int[] arr = {2, 1, 5, 6, 2, 3};
        int[] output = nextGreaterElement(arr);

        out.println("Input : " + Arrays.toString(arr));
        out.println("Output: " + Arrays.toString(output));
        out.flush();
    }
}
