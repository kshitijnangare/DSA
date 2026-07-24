class CheckBit {
    static boolean checkKthBit(int n, int k) {
        // code here
        if((n | (1<<k))==n)
            return true;
        else
            return false;
    }
}