class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;

        // Sort by (minimum - actual) in descending order
        Arrays.sort(tasks, (a, b) -> 
            Integer.compare(b[1] - b[0], a[1] - a[0])
        );

        int energy = tasks[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {

            // Add actual energy consumed
            energy += tasks[i][0];

            // Ensure minimum requirement is satisfied
            if (energy < tasks[i][1]) {
                energy = tasks[i][1];
            }
        }

        return energy;
    }
}