class Solution {
    public int maxArea(List<Integer> height) {
        // code here
        int n = height.size();
        if(n<=2){
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = n-1;
        while(left<right){
            int lefth = height.get(left);
            int righth = height.get(right);
            int dist = right -left-1;
            int h = Math.min(lefth, righth);
            int area = dist*h;
            maxArea = Math.max(area, maxArea);
            if(lefth<=righth){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}