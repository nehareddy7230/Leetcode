class Solution {

    public int numTrees(int n) {
        return trees(n);
    }

    public int trees(int n) {

        // 0 nodes = 1 empty tree
        // 1 node  = 1 tree
        if (n <= 1) {
            return 1;
        }

        int total = 0;

        // Try every node as root
        for (int i = 1; i <= n; i++) {

            // Nodes smaller than root
            int left = trees(i - 1);

            // Nodes greater than root
            int right = trees(n - i);

            // Every left tree can combine with every right tree
            total += left * right;
        }

        return total;
    }
}