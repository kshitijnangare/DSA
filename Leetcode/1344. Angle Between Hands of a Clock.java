class Solution {
    public double angleClock(int hour, int minutes) {
        // hour hand in one min = travels 0.5 degree
        // min hand in one min = travels 6 degree
        // in in one min net difference will be => diff = 6-0.5 = 5.5 degree
        // so in one min there is a difference of 5.5 degree between both the hands

        // assume the time at start is 12 AM/PM (0 degree between hour and min hands)
        // then find difference between the input time and 12 AM/PM
        // convert it all in min
        // multiply by 5.5 and do modulo 360 so that degree never goes beyond 360
        // if less than equal to 180 return
        // if greater than 180 then subtract from 360 and return

        int totalMin = hour*60 + minutes;
        double totalDegree = (totalMin * 5.5) % 360;
        if(totalDegree<=180){
            return totalDegree;
        }else{
            return 360-totalDegree;
        }
    }
}