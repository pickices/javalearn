public class IsSubsequence {

    public static void main(String[] args) {
        String s = "";
        String t = "abc";
        System.out.println(isSubsequence(s,t));

    }

    public static boolean isSubsequence(String s, String t) {
        int spoint=0;
        int tpoint=0;
        for(;tpoint<t.length()&&spoint<s.length();tpoint++){
            if(s.charAt(spoint)==t.charAt(tpoint)){
                spoint++;
            }
        }
        if(spoint==s.length())
            return true;
        return false;
    }
}
