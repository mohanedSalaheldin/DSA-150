import java.util.*;

public class Sol {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    islands++;
                    bfs(grid, r, c, visited, directions, rows, cols);
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        visited.add(r + "," + c);
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            for (int[] direction : directions) {
                int nr = row + direction[0], nc = col + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                    q.add(new int[]{nr, nc});
                    visited.add(nr + "," + nc);
                }
            }
        }
    }



    public int numIsland(char[][] grid) {
        int islands = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        Set<String> visted = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] =='1' && !visted.contains(r+","+c)) {
                    islands++;
                    bfs(grid, visted, r, c, ROWS, COLS);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, Set<String> visited, int r, int c, int rows, int cols) {
        Queue<int[]> q = new LinkedList();
        visited.add(r+","+c);
        q.add(new int[] {r,c});

        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0], col = point[1];
            for (int[] dir: dirs) {
               int nr = row+dir[0], nc = col+dir[1];
                if (c>=0 && r>=0 && r < rows && c<cols &&  grid[r][c] =='1' && !visited.contains(r+","+c)) {
                    visited.add(nr+","+nc);
                    q.add(new int[] {nr,nc});
                }
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Set<String> visited = new HashSet<>();
        int ans = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c]==1){
                   ans = Math.max(  bfsmaxArea(grid, visited, r, c), ans);
                }
            }
        }
        return ans;
    }
    private int bfsmaxArea(int[][] grid, Set visited, int r, int c,) {
        int ROWS = grid.length, COLS = grid[0].length;
        if(r<0 || c<0 || r >= ROWS || c>=COLS || grid[r][c]==0 || visited.contains(r+","+c))
            return 0;
        visited.add(r+","+c);
        return (1 +
                bfsmaxArea(grid, visited, r+1, c)+
                bfsmaxArea(grid, visited, r-1, c)+
                bfsmaxArea(grid, visited, r, c+1)+
                bfsmaxArea(grid, visited, r, c-1));
    }


}

