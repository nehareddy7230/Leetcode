/*class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 1;
        long c=0;
        c = c + nums.length;
        long op = 0;
        while(left<nums.length && right<nums.length)
        {
            int val = nums[left];
            while(op<=k && right<nums.length)
            {

                  val = Math.max(val,nums[right]);
                long diff = (long)val-nums[right];
                if(diff<=0)
                {
                    c = c + 1;
                }
                else if(op+diff<=k)
                {
                    c = c + 1;
                    op = op + diff;
                }
                else
                {
                    break;
                }
                right++;
            }
            op = 0;
            left++;
            right = left + 1;
        }
        return c;
    }
}*/

import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long ops = 0;
        long count = 0;

        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            int val = nums[left];
            int size = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] <= val) {

                int[] curr = dq.pollFirst();

                ops += (long) (val - curr[0]) * curr[1];

                size += curr[1];
            }

            dq.addFirst(new int[]{val, size});

            // Remove elements until operations <= k
            while (ops > k) {

                int[] curr = dq.peekLast();

                ops -= (long) (curr[0] - nums[right]);

                curr[1]--;

                if (curr[1] == 0) {
                    dq.pollLast();
                }

                right--;
            }

            // Count valid subarrays
            count += right - left + 1;
        }

        return count;
    }
}

