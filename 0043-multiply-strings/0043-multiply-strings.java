class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m + n];

        // Multiply every digit
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                // Add previous value already present
                int sum = mul + res[p2];

                // Store one's digit
                res[p2] = sum % 10;

                // Add carry
                res[p1] += sum / 10;
            }
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for(int num : res) {
            // Skip leading zeros
            if(!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }

        return ans.toString();
    }
}