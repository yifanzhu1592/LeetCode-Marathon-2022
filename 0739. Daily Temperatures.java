class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int hottest = 0;
        int answer[] = new int[temperatures.length];
        
        for (int currDay = temperatures.length - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }
        
        return answer;
    }
}
