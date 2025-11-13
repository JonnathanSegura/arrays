public class Minesweeper {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Minesweeper m n k");
            return;
        }
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        if (k < 0 || k > m * n) {
            throw new IllegalArgumentException("k must be between 0 and m*n");
        }

        boolean[][] mine = new boolean[m][n];

        int placed = 0;
        while (placed < k) {
            int r = (int) (Math.random() * m);
            int c = (int) (Math.random() * n);
            if (!mine[r][c]) {
                mine[r][c] = true;
                placed++;
            }
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mine[i][j]) {
                    System.out.print("*");
                } else {
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if (0 <= ni && ni < m && 0 <= nj && nj < n && mine[ni][nj]) {
                            cnt++;
                        }
                    }
                    System.out.print(cnt);
                }
                if (j < n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}