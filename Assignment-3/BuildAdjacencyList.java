import java.util.*;

    Map<Integer, Set<Integer>> adjacencySet(List<Pair<Integer, Integer>> edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (Pair<Integer, Integer> i : edges) {
            int start = i.getKey();
            int end = i.getValue();
            
            if (!graph.containsKey(start)) {
                graph.put(start, new HashSet<>());
            }
            
            graph.get(start).add(end);
            
            if (!graph.containsKey(end)) {
                graph.put(end, new HashSet<>());
            }
            
            graph.get(end).add(start);
        }
        
        return graph;
    }

    
    public static boolean bfs(int target, Map<Integer, Set<Integer>> graph) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == target) {
                return true;
            }

            set.add(curr);

            for (int i : graph.getOrDefault(curr, new HashSet<>())) {
                if (!set.contains(i)) {
                    queue.offer(i);
                }
            }
                  }

        return false;
    }

    // Depth-First Search (DFS) to search for a target value
    public static boolean dfs(int target, Map<Integer, Set<Integer>> graph) {
        Set<Integer> set = new HashSet<>();
        return dfsHelper(target, graph, set);
    }

    private static boolean dfsHelper(int current, Map<Integer, Set<Integer>> graph, Set<Integer> set) {
        set.add(curr);

        if (curr == target) {
            return true;
        }

        for (int i : graph.getOrDefault(curr, new HashSet<>())) {
            if (!set.contains(i) && dfsHelper(i, graph, set)) {
                return true;
            }
        }

        return false;
    }

   
    public static int[] topologicalSort(Map<Integer, Set<Integer>> graph) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i : graph.keySet()) {
            if (!set.contains(node)) {
                dfsTopologicalSort(node, graph, set, res);
            }
        }
       Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfsTopologicalSort(int curr, Map<Integer, Set<Integer>> graph, Set<Integer> set, List<Integer> res) {
        set.add(curr);

        for (int  i : graph.getOrDefault(curr, new HashSet<>())) {
            if (!set.contains(i)) {
                dfsTopologicalSort(i, graph, set, res);
            }
        }

        res.add(curr);
    }
}

// took 35 minutes
