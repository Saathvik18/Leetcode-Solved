class Solution {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        StringBuilder final_s = new StringBuilder();
        int max_count = 0;

        for (int i = 0; i < s.length(); i++) {

            int count = RetPal(s, i);
            boolean even = false;

            if (count < 0) {
                count = -count;
                even = true;
            }

            if (count > max_count) {
                max_count = count;
                final_s.setLength(0);

                if (!even) {
                    // odd length palindrome
                    int radius = count / 2;
                    for (int j = i - radius; j <= i + radius; j++) {
                        final_s.append(s.charAt(j));
                    }
                } else {
                    // even length palindrome
                    int radius = count / 2;
                    for (int j = i - radius + 1; j <= i + radius; j++) {
                        final_s.append(s.charAt(j));
                    }
                }
            }
        }

        return final_s.toString();
    }

    public int RetPal(String s, int pos) {

        int i = 0;

        // odd length
        while (pos - i >= 0 && pos + i < s.length() &&
               s.charAt(pos - i) == s.charAt(pos + i)) {
            i++;
        }

        int oddLen = 2 * (i - 1) + 1;

        // even length
        i = 0;
        while (pos - i >= 0 && pos + i + 1 < s.length() &&
               s.charAt(pos - i) == s.charAt(pos + i + 1)) {
            i++;
        }

        int evenLen = 2 * i;

        // return larger, encode even as negative
        if (evenLen > oddLen) {
            return -evenLen;
        } else {
            return oddLen;
        }
    }
}
