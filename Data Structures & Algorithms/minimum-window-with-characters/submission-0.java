class Solution {
    public String minWindow(String s, String t) {
        //find the exact amount of characters in t
        //start at l = 0, r = 0, have a counter for current window

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int sLength = Integer.MAX_VALUE;
        int[] sInd = new int[2];

        HashMap<Character, Integer> window = new HashMap<>();
        while (r < s.length()) {
            //extend r until the counts are equal
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            while (checkContains(tCount, window)) {
                if ((r - l + 1) < sLength) {
                    sLength = (r - l + 1);
                    sInd[0] = l;
                    sInd[1] = r + 1;
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if (window.get(s.charAt(l)) == 0) {
                    window.remove(s.charAt(l));
                }
                l++;
            }
            r++;
        }

        return s.substring(sInd[0], sInd[1]);
    }

    public boolean checkContains(HashMap<Character, Integer> t, HashMap<Character, Integer> window) {
        if (window.size() < t.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> e : t.entrySet()) {
            Integer val = window.get(e.getKey());
            if (val == null || val < e.getValue()) {
                return false;
            }
        }
        return true;
    }

}
