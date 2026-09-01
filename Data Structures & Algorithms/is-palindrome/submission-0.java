class Solution {
    public boolean isPalindrome(String s) {
        char[] vals = s.toLowerCase().toCharArray();

        int l = 0; 
        int r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetterOrDigit(vals[l])) {
                l++;
                continue;
            } else if (!Character.isLetterOrDigit(vals[r])) {
                r--; 
                continue;
            }
            
            if (vals[l] != vals[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
