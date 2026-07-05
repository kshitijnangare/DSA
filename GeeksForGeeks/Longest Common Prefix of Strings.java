class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        Arrays.sort(arr);
        int f = 0;
        int l = arr.length-1;
        int fi = 0;
        int li=0;
        int fn= arr[f].length();
        int ln= arr[l].length();
        int count = 0;

        while(fi<fn && li<ln){
            if(arr[f].charAt(fi)==arr[l].charAt(li)){
                count++;
            }else{
                break;
            }
            fi++;
            li++;
        }
        String s = arr[f].substring(0, count);
        return s;
    }
}