class Solution {

    static final long MOD = 1000000007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        long[] prefix = new long[n];      // prefix number after removing zeros (mod M)
        int[] digitSum = new int[n];      // prefix sum of non-zero digits
        int[] cnt = new int[n];           // prefix count of non-zero digits
        long[] pow = new long[n + 1];

        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        int d = s.charAt(0) - '0';

        if (d != 0) {
            prefix[0] = d;
            digitSum[0] = d;
            cnt[0] = 1;
        }

        for (int i = 1; i < n; i++) {

            d = s.charAt(i) - '0';

            prefix[i] = prefix[i - 1];
            digitSum[i] = digitSum[i - 1];
            cnt[i] = cnt[i - 1];

            if (d != 0) {
                prefix[i] = (prefix[i] * 10 + d) % MOD;
                digitSum[i] += d;
                cnt[i]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int len = cnt[r];
            int sum = digitSum[r];

            long value = prefix[r];

            if (l > 0) {
                len -= cnt[l - 1];
                sum -= digitSum[l - 1];

                value = (value -
                        (prefix[l - 1] * pow[len]) % MOD +
                        MOD) % MOD;
            }

            ans[i] = (int) ((value * sum) % MOD);
        }

        return ans;
    }
}