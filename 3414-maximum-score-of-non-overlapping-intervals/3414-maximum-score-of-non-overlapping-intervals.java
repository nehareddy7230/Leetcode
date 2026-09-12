class Solution {

    long[][] dp;
    List<Integer>[][] best;
    int[][] arr;
    int[] next;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[3], b[3]);
        });

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {

            int low = i + 1;
            int high = n - 1;
            int ans = n;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (arr[mid][0] > arr[i][1]) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = ans;
        }

        dp = new long[n + 1][5];
        best = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                best[i][k] = new ArrayList<>();
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: skip
                long skipScore = dp[i + 1][k];
                List<Integer> skipList = best[i + 1][k];

                // Option 2: take
                long takeScore = arr[i][2] + dp[next[i]][k - 1];

                List<Integer> takeList =
                    new ArrayList<>(best[next[i]][k - 1]);

                takeList.add(arr[i][3]);

                Collections.sort(takeList);

                if (takeScore > skipScore) {

                    dp[i][k] = takeScore;
                    best[i][k] = takeList;

                } else if (takeScore < skipScore) {

                    dp[i][k] = skipScore;
                    best[i][k] = skipList;

                } else {

                    // Same score → lexicographically smaller list
                    dp[i][k] = takeScore;

                    if (lexicographicallySmaller(takeList, skipList)) {
                        best[i][k] = takeList;
                    } else {
                        best[i][k] = skipList;
                    }
                }
            }
        }

        List<Integer> result = best[0][4];

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}