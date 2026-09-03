class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddcount = 0;
        int smallestOdd = Integer.MAX_VALUE;
        int smallestEven = Integer.MAX_VALUE;
        for(int x: nums1){
            if(x%2==1){
                oddcount++;
                smallestOdd = Math.min(smallestOdd, x);
            }else{
                smallestEven = Math.min(smallestEven, x);
            }
        }
        if(oddcount==0){
            return true;
        }else{
            if(smallestEven-smallestOdd >=1){
                return true;
            }else{
                return false;
            }
        }
    }
}

// case 1: no odd present -> make return true

// case 2: two or more odd present --> then also we need the smallestEven-smallestodd>=1
// because for 3 and 5 
// 5-3==2 
// but 3-5==-2 which is less than 1

// 2 3 4 5 6 7 8 9
// 2 2 4 2 6 2 8 2

// min 2 odd needed to make it of even parity
// if one odd present return false

// one odd present: 

// 1 4 6 8

// if only one odd present we need to make it odd parity only and to make odd parity
// we should have a odd number such that that odd-even is always greater than one


// 7 4 6 8

// but if nums[i]-nums[j]<1 then its a problem even if thats a negative odd number
// so we need to take care that the odd number is smallest from all even number and the smallest even number - odd number > 1

// 1 3 2 4
// 2 2 2 4

// summarising
// case 1: No odd number --> return true
// case 2: one odd number --> smallest even - odd number>1
// case 3: two or more odd --> smallest even - smallest odd number>1