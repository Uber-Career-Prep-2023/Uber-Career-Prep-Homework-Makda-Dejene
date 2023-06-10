import java.util.HashMap;
import java.util.Map;

public class RoadNetworks {
    private int[] parent;
    private int[] rank;

    public int countRoadNetworks(String[] towns, String[][] roads) {
        int n = towns.length;
        parent = new int[n];
        rank = new int[n];

       
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

       
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(towns[i], i);
        }

        
        for (String[] road : roads) {
            String town1 = road[0];
            String town2 = road[1];
            int index1 = map.get(town1);
            int index2 = map.get(town2);
            union(index1, index2);
        }

        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
           return count;
    }

    private void union(int x, int y) {
        int rootX = get(x);
        int rootY = get(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    private int get(int x) {
        if (parent[x] != x) {
            parent[x] = get(parent[x]);
        }
        return parent[x];
    }
}

// took 40 minutes
