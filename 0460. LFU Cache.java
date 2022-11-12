class LFUCache {

    int capacity;
    Map<Integer, Pair> map;
    PriorityQueue<Pair> pq;
    int stamp;
    int num;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        pq = new PriorityQueue<>();
        stamp = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Pair oldPair = map.get(key);
            pq.remove(oldPair);
            Pair newPair = new Pair(key, oldPair.value, oldPair.times + 1, stamp++);
            map.put(key, newPair);
            pq.offer(newPair);
            return newPair.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (map.containsKey(key)) {
            Pair oldPair = map.get(key);
            pq.remove(oldPair);
            Pair newPair = new Pair(key, value, oldPair.times + 1, stamp++);
            map.put(key, newPair);
            pq.offer(newPair);
        } else if (num >= capacity) {
            Pair removedPair = pq.poll();
            map.remove(removedPair.key);
            Pair newPair = new Pair(key, value, 1, stamp++);
            map.put(key, newPair);
            pq.offer(newPair);
        } else {
            num++;
            Pair newPair = new Pair(key, value, 1, stamp++);
            map.put(key, newPair);
            pq.offer(newPair);
        }
    }
}

class Pair implements Comparable<Pair> {
    int key;
    int value;
    int times;
    int stamp;
    
    public Pair(int key, int value, int times, int stamp) {
        this.key = key;
        this.value = value;
        this.times = times;
        this.stamp = stamp;
    }
    
    public int compareTo(Pair that) {
        if (this.times != that.times) {
            return this.times - that.times;
        } else {
            return this.stamp - that.stamp;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
