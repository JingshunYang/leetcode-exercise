class Solution {
    List<Integer> stack = new LinkedList<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(0, rooms);
        return stack.size() == rooms.size();
    }

    private void dfs(int curr, List<List<Integer>> rooms) {
        while (curr < rooms.size() && rooms.get(curr).size() > 0) {
            List<Integer> tempList = rooms.get(curr);
            while (!tempList.isEmpty()) {
                int temp = tempList.get(0);
                rooms.get(curr).remove(0);
                dfs(temp, rooms);
            }
        }
        if (!stack.contains(curr)) {
            stack.add(curr);
        }
    }
}
