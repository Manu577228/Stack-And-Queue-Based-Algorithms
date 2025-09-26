/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )                                         */
/*  ___ _                      _              _                                 */
/*  | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)                                */
/*  | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |                                */
/*  |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |                                */
/*                                     |__/                                     */
/* ----------------------------------------------------------------------------  */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                         */
/*    Github : https://github.com/Manu577228                                    */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio         */
/* ----------------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

class MonotonicQueue {
    Deque<Integer> q;

    MonotonicQueue() {
        // we use deque to store values in decreasing order
        q = new LinkedList<>();
    }

    void push(int x) {
        // remove smaller elements from back
        while (!q.isEmpty() && q.peekLast() < x) {
            q.pollLast();
        }
        // add new element
        q.offerLast(x);
    }

    int max() {
        // front of deque always holds maximum
        return q.peekFirst();
    }

    void pop(int x) {
        // if outgoing element equals current max, remove it
        if (!q.isEmpty() && q.peekFirst() == x) {
            q.pollFirst();
        }
    }
}

public class Main {
    public static List<Integer> slidingWindowMax(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        // process first k elements
        for (int i = 0; i < k; i++) {
            mq.push(nums[i]);
        }
        res.add(mq.max());

        // process remaining windows
        for (int i = k; i < nums.length; i++) {
            mq.push(nums[i]);         // add new element
            mq.pop(nums[i - k]);      // remove outgoing element
            res.add(mq.max());        // record current max
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> ans = slidingWindowMax(arr, k);
        System.out.println(ans);
    }
}
