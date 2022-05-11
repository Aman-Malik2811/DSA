class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb=new StringBuilder(s);
        if(sb.toString().equals(goal))return true;
        for(int i=0;i<sb.length();i++){
            char del=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(del);
            if(sb.toString().equals(goal))return true;
        }
        return false;
    }
}