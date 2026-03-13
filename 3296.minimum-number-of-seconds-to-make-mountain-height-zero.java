class Solution {
    static class Worker {
        long nextTime;
        int count;
        int baseTime;

        public Worker(long nextTime, int count, int baseTime) {
            this.nextTime = nextTime;
            this.count = count;
            this.baseTime = baseTime;
        }
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> Long.compare(a.nextTime, b.nextTime));
        
        // Initialize workers
        for (int time : workerTimes) {
            pq.offer(new Worker(time, 1, time));
        }
        
        while (mountainHeight > 0) {
            Worker worker = pq.poll();
            long currentTime = worker.nextTime;
            
            mountainHeight--;
            
            if (mountainHeight == 0) {
                return currentTime;
            }
            
            worker.count++;
            worker.nextTime = currentTime + (long)worker.count * worker.baseTime;
            
            pq.offer(worker);
        }
        
        return 0; // This line should never be reached if mountainHeight > 0
    }
}