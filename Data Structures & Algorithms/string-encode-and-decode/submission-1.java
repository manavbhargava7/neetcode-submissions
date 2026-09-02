class Solution {

    public String encode(List<String> strs) {
        //input a string array
        //output a string 
        
        //need either a delimiter or a number counter

        //delimiter is hard because the values can be any ascii value


        //number counter:

        StringBuilder ret = new StringBuilder();
        
        for (String s : strs) {
            // check the empty string case
            if (s == "") {
                ret.append(0);
                ret.append('m');
                continue;
            }
            ret.append(s.length());
            ret.append('m');
            ret.append(s);
        }
        System.out.println(ret.toString());

        return ret.toString();
    }

    public List<String> decode(String str) {
        List<String> l = new ArrayList<>();

        int c = 0;
        
        while (c < str.length()) {
            StringBuilder len = new StringBuilder();
            while (str.charAt(c) != 'm') {
                len.append(str.charAt(c));
                c++;
            }
            c++;
            int length = Integer.parseInt(len.toString());

            if (length == 0) {
                l.add("");
                continue;
            }

            StringBuilder s = new StringBuilder();
            
            for (int i = 0; i < length; i++) {
                s.append(str.charAt(c + i));
            }

            l.add(s.toString());
            c += length;
        }

        return l;
    }
}
