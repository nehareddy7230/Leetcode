class Solution {
    static final long MOD = 1000000007;

    public int numberOfSets(int n, int k) {
        long ans = 1;
        int N = n + k - 1;
        int R = 2 * k;

        for (int i = 1; i <= R; i++) {
            ans = ans * (N - R + i) % MOD;
            ans = ans * modInverse(i) % MOD;
        }

        return (int) ans;
    }

    long modInverse(long x) {
        return power(x, MOD - 2);
    }

    long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                result = result * a % MOD;

            a = a * a % MOD;
            b /= 2;
        }

        return result;
    }
}