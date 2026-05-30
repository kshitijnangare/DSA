class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        int lastStored = 0;
        while(i<n && j<m){
            if(a[i]==b[j]){
                if(lastStored!=a[i]) {
                    list.add(a[i]);
                    lastStored = a[i];
                }
                i++;
                j++;
            }else if(a[i]<b[j]){
                if(lastStored!=a[i]) {
                    list.add(a[i]);
                    lastStored = a[i];
                }
                i++;
            }else{
                if(lastStored!=b[j]) {
                    list.add(b[j]);
                    lastStored = b[j];
                }
                j++;
            }
        }
        while(i<n){
            if(lastStored!=a[i]) {
                list.add(a[i]);
                lastStored = a[i];
            }
            i++;
        }
        while(j<m){
            if(lastStored!=b[j]) {
                list.add(b[j]);
                lastStored = b[j];
            }
            j++;
        }
        return list;
    }
}
