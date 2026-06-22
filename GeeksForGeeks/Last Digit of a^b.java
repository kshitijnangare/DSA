class Solution {
    public int getLastDigit(String a, String b) {
        // code here
        if(b.equals("0")){
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        int blen = b.length();
        int alen = a.length();
        char lasta = a.charAt(alen-1);
        StringBuilder sa = new StringBuilder();
        sa.append(lasta);
        int anum = Integer.parseInt(sa.toString());
        
        if(blen!=1){
            char c1 = b.charAt(blen-1);
            char c2 = b.charAt(blen-2);
            sb.append(c2);
            sb.append(c1);
        }else{
            char c1 = b.charAt(blen-1);
            sb.append(c1);
        }
        int lastTwoDigits = Integer.parseInt(sb.toString());
        int rem = lastTwoDigits % 4;
        if(rem == 0){rem = 4;}
        int lastDigit = (int) Math.pow(anum, rem) % 10;
        return lastDigit;
    }
};