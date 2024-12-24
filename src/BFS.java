import java.util.*;

public class BFS {

    public int bfs(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] vis = new int[ROWS][COLS];
        Deque<int[]> q = new ArrayDeque<>();
        int len = 0;

        q.add(new int[] {0,0});
        vis[0][0] = 1;
        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
                {-1, -1},
                {1, -1},
                {1, 1},
                {-1, 1},
        };
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pair = q.poll();
                int r = pair[0], c = pair[1];
                if (r==ROWS-1 && c==COLS-1)
                    return len;
                for (int[] dir: dirs) {
                    int nr = r+dir[0], nc = c+dir[1];
                    if (nc<0 || nr<0 || nr >= ROWS || nc>=COLS || grid[nr][nc]==1 || vis[nr][nc]==1)
                        continue;
                    q.add(new int[] {nr,nc});
                    vis[nr][nc] = 1;
                }
            }
            len++;
        }
        return -1;
    }

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Deque<int[]> q = new ArrayDeque();
        int t= 0, fresh = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c]==1)
                    fresh++;
                if (grid[r][c]==2)
                    q.add(new int[]{r,c});
            }
        }


        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!q.isEmpty() && fresh>0){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pair = q.poll();
                int r = pair[0], c = pair[1];
                for (int[] d : dirs) {
                    int nr = r+d[0], nc = c+d[1];
                    if (nr<0 || nc<0 || nr>=R || nc>=C || grid[nr][nc]!=1)
                        continue;
                    q.add(new int[] {nr,nc});
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
            t++;
        }
        return fresh == 0 ? t : -1;
    }
}
