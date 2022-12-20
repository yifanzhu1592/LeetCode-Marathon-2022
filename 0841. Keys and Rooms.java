class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            for (int nextRoom : rooms.get(currentRoom)) {
                if (!seen.contains(nextRoom)) {
                    queue.add(nextRoom);
                    seen.add(nextRoom);
                    if (rooms.size() == seen.size()) {
                        return true;
                    }
                }
            }
        }
        return rooms.size() == seen.size();
    }
}
