class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxarea = Integer.MIN_VALUE;
        int[] prow = new int[col];
        Arrays.fill(prow, 0);
        for(int i =0; i<row; i++){
            int[] crow = new int[col];
            for(int j = 0; j<col; j++){
                char c = matrix[i][j];
                int n = c - '0';
                if(n==0){
                    crow[j]=0;
                }else{
                    crow[j] = prow[j] + n;
                }
            }
            int area = largestRectangleArea(crow);
            maxarea = Math.max(area, maxarea);
            prow = crow;
        }
        return maxarea;
    }
    int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= (i < n ? heights[i] : 0))) {
                int height = heights[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i; 
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}