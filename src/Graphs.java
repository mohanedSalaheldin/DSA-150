public class Graphs {
    public static void main(String[] args) {
       int[][] grid  = {
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 1, 0, 0}
        };

    }

    static int dfs(int[][] grid, int r, int c, int[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (Math.min(r,c) < 0 || c == COLS || r ==ROWS ||  visit[r][c] == 1 || grid[r][c] == 1)
            return 0;
        if (c == COLS-1 && r == ROWS-1)
            return 1;
        visit[r][c] = 1;
        int count = 0;
        count+= dfs(grid, r+1, c, visit);
        count+= dfs(grid, r-1, c, visit);
        count+= dfs(grid, r, c+1, visit);
        count+= dfs(grid, r, c-1, visit);
        visit[r][c] = 1;
        return count;
    }
    static int myGraphdfs(int[][] grid, int[][] visit, int r, int c){
        int ROWS = grid.length, COLS = grid[0].length;
        if (c < 0|| r < 0 || c >= COLS || r >= ROWS || grid[r][c] == 1 || visit[r][c] == 1)
            return 0;
        if (r == ROWS-1 && c == COLS-1)
            return 1;
        visit[r][c] = 1;
        int count = 0;
        count+= myGraphdfs(grid, visit, r-1, c);
        count+= myGraphdfs(grid, visit, r+1, c);
        count+= myGraphdfs(grid, visit, r, c-1);
        count+= myGraphdfs(grid, visit, r, c+1);

        visit[r][c] = 0;
        return count;
    }

//    static bfs(){
//
//    }
}
