class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //sort each string to similar characters

        HashMap<String, List<String>> m = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);

            List<String> l = m.getOrDefault(s, new ArrayList<>());
            l.add(strs[i]);

            m.put(s, l);
        }

        List<List<String>> ret = new ArrayList<>();

        for (String s : m.keySet()) {
            ret.add(m.get(s));
        }

        return ret;
    }
}
