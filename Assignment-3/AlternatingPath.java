public class AlternatingPath {
  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
          Set<Integer>[][] graph = new HashSet[2][n];
          for (int i = 0; i < n; i++) {
              graph[0][i] = new HashSet<>();
              graph[1][i] = new HashSet<>();
          }

          for (int[] red : red_edges) {
              graph[0][red[0]].add(red[1]);
          }

          for (int[] blue : blue_edges) {
              graph[1][blue[0]].add(blue[1]);
          }

          int[][] res = new int[2][n];
          for (int i = 1; i < n; i++) {
              res[0][i] = 2 * n;
              res[1][i] = 2 * n;
          }

          Queue<int[]> queue = new LinkedList<>();
          queue.offer(new int[]{0, 0});
          queue.offer(new int[]{0, 1});

          while (!queue.isEmpty()) {
              int[] cur = queue.poll();
              int vert = cur[0];
              int color = cur[1];

              for (int next : graph[1 - color][vert]) {
                  if (res[1 - color][next] == 2 * n) {
                      res[1 - color][next] = 1 + res[color][vert];
                      queue.offer(new int[]{next, 1 - color});
                  }
              }
          }

          int[] ans = new int[n];
          for (int i = 0; i < n; i++) {
              int t = Math.min(res[0][i], res[1][i]);
              ans[i] = (t == 2 * n) ? -1 : t;
          }

          return ans;
      }
}

// took 30 minutes
