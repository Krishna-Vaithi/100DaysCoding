package Day90;

import java.util.LinkedList;

public class Day90 {
    public static void main(String[] args) {
        Day90 day90 = new Day90();
        int[][] grid1 = { { 1, 1, 1, 1, 0, 0 }, { 1, 1, 0, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } };
        int[][] grid2 = { { 1, 1, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0 } };
        System.out.println(day90.countSubIslands(grid1, grid2));
    }
    private int[][] offs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int subIslands = 0;

            for (int i = 0; i < grid1.length; i++) {
                for (int j = 0; j < grid1[0].length; j++) {
                    if (grid1[i][j] == 0) continue;
                    bfsGrid(grid1, grid2, i, j, false);
                }
            }

            for (int i = 0; i < grid1.length; i++) {
                for (int j = 0; j < grid1[0].length; j++) {
                    if (grid2[i][j] == 0 || grid2[i][j] == 1) continue;
                    if (bfsGrid(null, grid2, i, j, true)) subIslands++;
                }
            }

            return subIslands;
        }

        private boolean bfsGrid(int[][] grid1, int[][] grid2, int x, int y, boolean isGrid2) {
            LinkedList<int[]> queue = new LinkedList<>();
            boolean isSubIsland = true;

            queue.add(new int[]{x, y});

            if (isGrid2) {
                grid2[x][y] = 0;
            } else {
                grid1[x][y] = 0;
                grid2[x][y] = grid2[x][y] == 1 ? 2 : grid2[x][y];
            }

            while (queue.size() > 0) {
                int[] curr = queue.removeFirst();
                int cX = curr[0];
                int cY = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nX = cX + this.offs[i][0];
                    int nY = cY + this.offs[i][1];

                    if (Math.min(nX, nY) < 0 || nX >= grid2.length || nY >= grid2[0].length) {
                        continue;
                    } else if (isGrid2) {
                        if (grid2[nX][nY] == 0) continue;
                        else if (grid2[nX][nY] == 1) isSubIsland = false;
                    } else if (grid1[nX][nY] == 0) {
                        continue;
                    }

                    if (isGrid2) {
                        grid2[nX][nY] = 0;
                    } else {
                        grid1[nX][nY] = 0;
                        grid2[nX][nY] = grid2[nX][nY] == 1 ? 2 : grid2[nX][nY];
                    }

                    queue.add(new int[]{nX, nY});
                }
            }
            return isSubIsland;
        }
}
