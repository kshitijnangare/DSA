class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        
        for(int i = 1; i<arr.length; i++){
            if(st.isEmpty()){
                st.push(arr[i]);
                continue;
            }
            boolean stPos = st.peek()>=0 ? true: false;
            boolean elePos = arr[i] >= 0 ? true: false;
            
            if(stPos==elePos){
                st.push(arr[i]);
            }else{
                st.pop();
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int len = st.size();
        for(int i = 0; i<len; i++){
            list.add(st.get(i));
        }
        return list;
    }
}