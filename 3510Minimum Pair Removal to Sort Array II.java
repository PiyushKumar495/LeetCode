import java.util.*;

class Solution {

    static class Node {
        long val;
        int idx;
        Node prev, next;
        boolean alive = true;
        Node(long v, int i) {
            val = v;
            idx = i;
        }
    }

    static class Pair {
        long sum;
        Node left;
        Pair(long s, Node l) {
            sum = s;
            left = l;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(nums[i], i);

        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[i + 1].prev = nodes[i];
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
                return Integer.compare(a.left.idx, b.left.idx);
            }
        );

        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(nodes[i].val + nodes[i + 1].val, nodes[i]));
        }

        int ops = 0;

        while (true) {
            boolean sorted = true;
            Node cur = nodes[0];
            while (cur != null && cur.next != null) {
                if (cur.val > cur.next.val) {
                    sorted = false;
                    break;
                }
                cur = cur.next;
            }
            if (sorted) break;

            Pair p;
            while (true) {
                p = pq.poll();
                Node l = p.left;
                if (l.alive && l.next != null && l.next.alive &&
                    l.val + l.next.val == p.sum) break;
            }

            Node l = p.left;
            Node r = l.next;

            l.val += r.val;
            r.alive = false;
            l.next = r.next;
            if (r.next != null) r.next.prev = l;

            if (l.prev != null)
                pq.add(new Pair(l.prev.val + l.val, l.prev));
            if (l.next != null)
                pq.add(new Pair(l.val + l.next.val, l));

            ops++;
        }

        return ops;
    }
}