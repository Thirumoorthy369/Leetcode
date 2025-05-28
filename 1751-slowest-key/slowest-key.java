class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int prev_time = 0, max_time = 0;
        char slowest_key = '\0';

        for (int i = 0; i < keysPressed.length(); i++) {
            int current_time = releaseTimes[i] - prev_time;
            if (current_time > max_time || (current_time == max_time && keysPressed.charAt(i) > slowest_key)) {
                slowest_key = keysPressed.charAt(i);
                max_time = current_time;
            }
            prev_time = releaseTimes[i];
        }
        return slowest_key;
    }
}