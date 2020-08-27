class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerray = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets) {
            String source = ticket.get(0), target = ticket.get(1);
            if (!map.containsKey(source)) {
                map.put(source, new PriorityQueue<String>());
            }
            map.get(source).add(target);
        }
        dfs("JFK");
        Collections.reverse(itinerray);
        return  itinerray;
    }
    private void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerray.add(curr);
    }
}
