class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        Two pointers, expand the window as long as we havent seen the character already. once we already have it in the set, set index of l to the index 1 greater than the last occurence
        */

        int l = 0;
        int r = 0;

        int maxLength = 0;
        Set<Character> window = new HashSet<>(); //chars in window

        while (r < s.length()) {
            if (!window.contains(s.charAt(r))) {
                window.add(s.charAt(r));
                maxLength = Math.max(r - l + 1, maxLength);
            } else {
                while (s.charAt(l) != s.charAt(r)) {
                    window.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            r++;
        }

        return maxLength;
    }
}
