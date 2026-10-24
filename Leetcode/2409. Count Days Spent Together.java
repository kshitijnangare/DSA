class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int aA = convertToDays(arriveAlice, days);
        int lA = convertToDays(leaveAlice, days);
        int aB = convertToDays(arriveBob, days);
        int lB = convertToDays(leaveBob, days);
        
        int startR = Math.max(aA, aB);
        int endR = Math.min(lA, lB);
        
        return Math.max(0, endR - startR + 1);
    }
    
    private int convertToDays(String dateStr, int[] days) {
        int month = Integer.parseInt(dateStr.substring(0, 2));
        int day = Integer.parseInt(dateStr.substring(3, 5));
        
        int totalDays = day;
        for (int i = 1; i < month; i++) {
            totalDays += days[i];
        }
        return totalDays;
    }
}