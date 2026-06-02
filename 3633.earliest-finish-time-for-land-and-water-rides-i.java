
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landMin = Integer.MAX_VALUE;
        int waterMin = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            int finishTime = landStartTime[i] + landDuration[i];
            if (finishTime < landMin) landMin = finishTime;
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            int temp = 0;
            if (waterStartTime[i] > landMin) temp = waterStartTime[i] - landMin;

            int finishTime = temp + landMin + waterDuration[i];
            if (finishTime < waterMin) waterMin = finishTime;
        }

        int ans1 = waterMin;

        landMin = Integer.MAX_VALUE;
        waterMin = Integer.MAX_VALUE;

        for (int i = 0; i < waterStartTime.length; i++) {
            int finishTime = waterStartTime[i] + waterDuration[i];
            if (finishTime < waterMin) waterMin = finishTime;
        }

        for (int i = 0; i < landStartTime.length; i++) {
            int temp = 0;
            if (landStartTime[i] > waterMin) temp = landStartTime[i] - waterMin;

            int finishTime = temp + waterMin + landDuration[i];
            if (finishTime < landMin) landMin = finishTime;
        }

        int ans2 = landMin;
        return Math.min(ans1, ans2);
    }
}