class LRUCache {
    
    Map<Integer, Pair> map;
    Queue<Pair> queue;
    int capacity;
    int stamp;
    int num;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        queue = new PriorityQueue<>();
        this.capacity = capacity;
        stamp = 0;
        num = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Pair oldPair = map.get(key);
        queue.remove(oldPair);
        Pair newPair = new Pair(key, oldPair.value, stamp++);
        map.put(key, newPair);
        queue.offer(newPair);
        
        return oldPair.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (map.containsKey(key)) {
            Pair oldPair = map.get(key);
            queue.remove(oldPair);
        } else if (num >= capacity) {
            Pair removedPair = queue.poll();
            map.remove(removedPair.key);
        } else {
            num++;
        }
        
        Pair newPair = new Pair(key, value, stamp++);
        map.put(key, newPair);
        queue.offer(newPair);
    }
    
    class Pair implements Comparable<Pair> {
        int key;
        int value;
        int stamp;
        
        public Pair(int key, int value, int stamp) {
            this.key = key;
            this.value = value;
            this.stamp = stamp;
        }
        
        public int compareTo(Pair that) {
            return this.stamp - that.stamp;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
