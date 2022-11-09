class SnakeGame {

    int width;
    int height;
    int[][] food;
    int foodIndex;
    Set<Integer> set;
    Deque<Integer> queue;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
        set = new HashSet<Integer>();
        set.add(0);
        queue = new LinkedList<Integer>();
        queue.offerFirst(0);
    }
    
    public int move(String direction) {
        int headRow = queue.peekFirst() / width;
        int headCol = queue.peekFirst() % width;
        switch (direction) {
            case "U":
                headRow--;
                break;
            case "D":
                headRow++;
                break;
            case "R":
                headCol++;
                break;
            case "L":
                headCol--;
                break;
            default:
        }
        int newHead = headRow * width + headCol;
        set.remove(queue.peekLast());
        if (headRow < 0 || headRow >= height || headCol < 0 || headCol >= width || set.contains(newHead)) {
            return -1;
        }
        if (foodIndex < food.length && headRow == food[foodIndex][0] && headCol == food[foodIndex][1]) {
            foodIndex++;
            set.add(newHead);
            set.add(queue.peekLast());
            queue.offerFirst(newHead);
            return foodIndex;
        }
        set.add(newHead);
        queue.offerFirst(newHead);
        queue.removeLast();
        return foodIndex;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
