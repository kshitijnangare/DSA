class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> Integer.compare(b[1], a[1]));
        int totalUnits = 0;
        int i = 0;
        while(i<boxTypes.length && truckSize>0){
            int noOfBoxes = boxTypes[i][0];
            int noOfUnits = boxTypes[i][1];
            
            if(noOfBoxes<=truckSize){
                int units = noOfBoxes*noOfUnits;
                totalUnits+=units;
                truckSize=truckSize-noOfBoxes;
            }else{
                int units = truckSize*noOfUnits;
                totalUnits+=units;
                truckSize=0;
            }
            i++;
        }
        return totalUnits;
    }
}