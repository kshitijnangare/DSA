class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        double Dmass = mass;
        for(int i = 0; i<asteroids.length; i++){
            if(Dmass<asteroids[i]){
                return false;
            }
            Dmass+=asteroids[i];
        }
        return true;
    }
}