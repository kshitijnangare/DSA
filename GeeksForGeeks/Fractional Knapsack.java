class Item{
    int p;
    int w;
    Item(int p, int w){
        this.w = w;
        this.p = p;
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        Item[] arr = new Item[val.length];
        for(int i = 0; i<val.length; i++){
            arr[i] = new Item(val[i], wt[i]);
        }
        
        Arrays.sort(arr, (a,b)->{
            return Double.compare((double)b.p/b.w , (double)a.p/a.w);
        });
        
        double totalProf=0.0;
        int i = 0;
        while(capacity>0 && i<val.length){
            if(arr[i].w <= capacity) {
                totalProf += arr[i].p;
                capacity -= arr[i].w;
            } else {
                totalProf += ((double)capacity / arr[i].w) * arr[i].p;
                capacity = 0;
            }
            i++;
        }
        return totalProf;
    }
}