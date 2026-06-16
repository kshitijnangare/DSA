public class Solution {  

    public static void sortZeroesAndOne(int[] arr) {
    	//Your code goes here
        int i = 0; int j = 0;
        while(i<arr.length){
            if(arr[i]==0){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
            i++;
        }
        while(j<arr.length){
            arr[j]=1;
            j++;
        }
    }
}