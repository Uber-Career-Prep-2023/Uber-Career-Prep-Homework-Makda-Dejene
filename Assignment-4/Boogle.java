import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Boggle {
    public List<String> findWords(char[][] board, String[] dictionary) {
        Set<String> validWords = new HashSet<>();

        for (String word : dictionary) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if (dfs(board, i, j, word, 0, visited)) {
                            validWords.add(word);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(validWords);
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        boolean found = dfs(board, i - 1, j - 1, word, index + 1, visited) ||
                        dfs(board, i - 1, j, word, index + 1, visited) ||
                        dfs(board, i - 1, j + 1, word, index + 1, visited) ||
                        dfs(board, i, j - 1, word, index + 1, visited) ||
                        dfs(board, i, j + 1, word, index + 1, visited) ||
                        dfs(board, i + 1, j - 1, word, index + 1, visited) ||
                        dfs(board, i + 1, j, word, index + 1, visited) ||
                        dfs(board, i + 1, j + 1, word, index + 1, visited);

        visited[i][j] = false;

        return found;
    }
}
