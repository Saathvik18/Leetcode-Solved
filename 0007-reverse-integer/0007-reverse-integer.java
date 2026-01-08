class Solution {
    public int reverse(int x) {
        int temp;
        if (x >= 0) {
            temp = x;
        } else {
            if (x == Integer.MIN_VALUE) return 0;
            temp = -x;
        }

        int rem = 0;
        int ans = 0;

        while (temp > 0) {
            rem = temp % 10;
            if (ans > Integer.MAX_VALUE / 10 ||
               (ans == Integer.MAX_VALUE / 10 && rem > 7)) //bcoz 2^31 - 1 last digit is 7
                return 0;
            ans = ans * 10 + rem;
            temp /= 10;
        }

        if (x >= 0) {
            return ans;
        } else {
            return -ans;
        }
    }
}
