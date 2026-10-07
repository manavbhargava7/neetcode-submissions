class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> counts = new HashMap<>();

        int maxLength = 1;

        int l = 0; 
        int r = 0;

        int maxf = 0;
        int res = 0;

        while (r < s.length()) {
            counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, counts.get(s.charAt(r)));

            while((r - l + 1) - maxf > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}
